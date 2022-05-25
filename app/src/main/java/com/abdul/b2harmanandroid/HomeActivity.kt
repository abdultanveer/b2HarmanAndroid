package com.abdul.b2harmanandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //get the data from main activity
            //get the intent which started this activity
            //from that intent get the extras
            //from that extras get the string with the key/tag = harmankey
        //show that data in a textview
            //get the handle on the textview
            //set the text/string that you got from the previous step
    
    }

    fun clickHandler(view: View) {
        var hIntent = Intent(this, MainActivity::class.java)
        startActivity(hIntent)
    }
}