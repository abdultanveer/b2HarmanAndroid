package com.abdul.b2harmanandroid;

import androidx.appcompat.app.AppCompatActivity;

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
}