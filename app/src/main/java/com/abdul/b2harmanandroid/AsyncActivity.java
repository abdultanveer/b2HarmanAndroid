package com.abdul.b2harmanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class AsyncActivity extends AppCompatActivity {
    ProgressBar progressBar;
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
        }
    }
}