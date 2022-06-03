package com.abdul.b2harmanandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AsyncActivity extends AppCompatActivity {
    ProgressBar progressBar;
    LocalService.LocalBinder localBinderPipe;
    LocalService localService;
    NotificationManager notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        progressBar = findViewById(R.id.progressBar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            notificationManager = getSystemService(NotificationManager.class);
        }

    }

    public void startDownload(View view) {
        //download on background thread and show the updates on the ui thread
        DownloadTask downloadTask = new DownloadTask(progressBar);
        downloadTask.execute("https:myphoto.com");
    }

    public void serviceHandler(View view) {
        Intent serviceIntent = new Intent(AsyncActivity.this,MusicService.class);

        switch (view.getId()){
            case R.id.btnStart:
                serviceIntent.putExtra("musicname","some.mp3");
                startService(serviceIntent);
                break;
            case R.id.btnStop:
                stopService(serviceIntent);
                break;
            case R.id.btnBind:
                Intent bindIntent = new Intent(AsyncActivity.this, LocalService.class);
                //step1 -- im binding to a shop, im not setting up a shop
                bindService(bindIntent,bondSignSerConn, Service.BIND_AUTO_CREATE); //if the service is not running then please auto create
                break;
            case R.id.btnUnbind:
                unbindService(bondSignSerConn);
                break;
        }
    }

    /**
     * bond between activity and localservice -- help in communication
     */
    ServiceConnection bondSignSerConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder binderPipe) {
            //step3
            localBinderPipe = (LocalService.LocalBinder) binderPipe;
           localService = localBinderPipe.getService(); //LocalService localService = new LocalService();
            String ad = localService.getAds();
            int rNo = localService.getRandomNumber(); // im able to invoke the methods of localservice with creating an object of it
            Toast.makeText(localService, ad + rNo, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    public void showNotification(View view) {
        createNotificationChannel();
        Intent intent = new Intent(this, WhoWroteItActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .addAction(R.drawable.ic_baseline_snooze_24, getString(R.string.snooze),pendingIntent)

                //.setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_baseline_assistant_direction_24)
                .setContentTitle("My notification title")
                .setContentText("text Much longer text that cannot fit one line...")
                .setStyle(new NotificationCompat.BigTextStyle()
                .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        Notification notification = builder.build();
        notificationManager.notify(123,notification);
    }


    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "important channel";
                    //getString(R.string.channel_name);
            String description = "this channel is about rides";
                    //getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
             notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}