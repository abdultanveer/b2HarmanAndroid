package com.abdul.b2harmanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.abdul.b2harmanandroid.whowrote.FetchBook;

public class WhoWroteItActivity extends AppCompatActivity {
    EditText mBookInput;
    TextView mAuthorText,mTitleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_wrote_it);

        mBookInput = findViewById(R.id.bookInput);
        mAuthorText = findViewById(R.id.authorText);
        mTitleText = findViewById(R.id.titleText);
    }

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();
        new FetchBook(mTitleText, mAuthorText).execute(queryString);

    }
}