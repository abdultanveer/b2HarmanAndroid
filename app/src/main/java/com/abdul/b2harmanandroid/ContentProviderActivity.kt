package com.abdul.b2harmanandroid

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import com.abdul.b2harmanandroid.database.FeedReaderContract

class ContentProviderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        getSmsInbox()
    }

    private fun getSmsInbox() {
        val uriSms: Uri = Uri.parse("content://call_log/calls")
            //"content://sms/inbox")
        val dataCursor: Cursor? = getContentResolver().query(uriSms, null, null, null, null)

        var from = arrayOf(android.provider.CallLog.Calls.NUMBER)
        var to = intArrayOf(android.R.id.text1)
        var adapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_1, //layout of each row of listview
            dataCursor, //data
            from, //names of the columns in db table
            to) //id's of the textviews in simple_list_item_2 layout
        var dataListView: ListView = findViewById(R.id.cpListv)
        dataListView.adapter = adapter
    }
}