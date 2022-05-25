package com.abdul.b2harmanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText; //declaration
    public static  String TAG = MainActivity.class.getSimpleName(); //"MainActivity"

    @Override
    protected void onCreate(Bundle savedInstanceState) { //getting created -- memory is allocated - coming out of sdcard/storage and getting into ram
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflating xml
        Log.i(TAG,"oncreate");
        nameEditText = findViewById(R.id.etName); //initialization -- getting hold of the edittext/ taking handle
        Employee ansari = new Employee("abdul", 123, true);
        ansari.seteName("abdul");
        Student abdul = new Student("ansari", 123, true);
    }

    @Override
    protected void onStart() { //activity is created and visible to the user
        super.onStart();
        Log.e(TAG,"onstart");
    }

    @Override //activity is going into the background -- sleep
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"onpause");
    }

    @Override //waking up -- ready to interact-- handle button clicks
    protected void onResume() {
        super.onResume();
        Log.w(TAG,"onresume");
    }

    /**
     * hibernate in windows
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG,"onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"ondestroy");

    }

    public void handleClick(View viewClicked) {
        switch (viewClicked.getId()){
            case R.id.btnSubmit:
                startHome();
                break;
            case R.id.btnDial:
                startDialer();
                break;
            case R.id.btnAlarm:
                createAlarm("b2harman",11,29);
                break;
        }



    }

    private void startDialer() {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9880979732"));
        startActivity(dialIntent);
    }

    private void startHome() {
        String name = nameEditText.getText().toString();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
        hIntent.putExtra("harmankey",name);
        startActivity(hIntent);
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

