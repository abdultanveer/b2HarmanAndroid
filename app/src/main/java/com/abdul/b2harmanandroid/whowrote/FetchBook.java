package com.abdul.b2harmanandroid.whowrote;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        //parse the json and get the name of the author
        parseJson(bookJSONString);
    }

    private void parseJson(String bookJSONString) {

        try {
            //get the whole json
            JSONObject jsonObject = new JSONObject(bookJSONString);
            //get jsonarray named items
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            //get the first item in that itemsArray
            for(int i = 0; i<itemsArray.length(); i++) {
                JSONObject bookFirstItem = itemsArray.getJSONObject(i);
                //fromt the first item get the volumeinfo json
                JSONObject volumeInfo = bookFirstItem.getJSONObject("volumeInfo");
                String title=null;
                String authors=null;
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors"); //debug this line
                } catch (Exception e){
                    e.printStackTrace();
                }
                if (title != null && authors != null){
                    mTitleText.setText(title);
                    mAuthorText.setText(authors);
                    return;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}