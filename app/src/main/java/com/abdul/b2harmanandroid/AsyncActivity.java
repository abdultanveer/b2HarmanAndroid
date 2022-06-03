package com.abdul.b2harmanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AsyncActivity extends AppCompatActivity {
    ProgressBar progressBar;
    LocalService.LocalBinder localBinderPipe;
    LocalService localService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        progressBar = findViewById(R.id.progressBar);
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
}