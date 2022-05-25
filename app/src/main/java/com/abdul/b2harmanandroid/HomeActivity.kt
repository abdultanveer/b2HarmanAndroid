package com.abdul.b2harmanandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    lateinit var tvHome : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //get the data from main activity
            //get the intent which started this activity
            var intentStarted = intent;
            //from that intent get the extras
            var extras = intentStarted.extras
            //from that extras get the string with the key/tag = harmankey
            var data = extras?.getString("harmankey")
        //show that data in a textview
            //get the handle on the textview
            tvHome = findViewById(R.id.tvHome)
            //set the text/string that you got from the previous step
            //tvHome.setText(data)
            tvHome.text = data
    }

    fun clickHandler(view: View) {
        var hIntent = Intent(this, MainActivity::class.java)
        startActivity(hIntent)
    }
}