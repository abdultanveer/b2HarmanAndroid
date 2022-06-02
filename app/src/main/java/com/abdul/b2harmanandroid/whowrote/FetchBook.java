package com.abdul.b2harmanandroid.whowrote;

import android.os.AsyncTask;
import android.widget.TextView;

public class FetchBook extends AsyncTask<String, Void, String> {
    private TextView mTitleText;
    private TextView mAuthorText;

    public FetchBook(TextView mTitleText, TextView mAuthorText) {
        this.mTitleText = mTitleText;
        this.mAuthorText = mAuthorText;
    }

    @Override
    protected String doInBackground(String... queryStrings) {
        //get the json string from the webservice and return that json string

        return NetworkUtils.getBookInfo(queryStrings[0]);
    }

    @Override
    protected void onPostExecute(String bookJSONString) {
        super.onPostExecute(bookJSONString);
    }
}