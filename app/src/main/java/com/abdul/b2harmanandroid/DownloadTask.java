package com.abdul.b2harmanandroid;


import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

//i/p = string url, progress = integer percentage downloaded, resulttype = bitmap
public class DownloadTask extends AsyncTask<String,Integer, Bitmap> {
    public static String TAG = DownloadTask.class.getSimpleName();
    ProgressBar mprProgressBar;
    public DownloadTask(ProgressBar progressBar) {
        mprProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mprProgressBar.setVisibility(View.VISIBLE);
    }

    /**
     * the code in doinbackground will be executed on a seperate thread
     * put the blocking calls on a seperate thread
     * @param strings
     * @return
     */
    @Override
    protected Bitmap doInBackground(String... strings) {
        Log.i(TAG,"i am downloading--"+strings[0]);
        for(int i=1;i<21;i++) {
            try {
                Thread.sleep(200);
                publishProgress(i *5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mprProgressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        Log.i(TAG,"i am done downloading the photo i'll show you now");

    }
}
