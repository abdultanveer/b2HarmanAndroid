package com.abdul.b2harmanandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    lateinit var contactEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        contactEditText = findViewById(R.id.etContact)

    }

    fun clickHandler(view: View) {
        //get the contact from the edittext
        var data = contactEditText.text.toString()
        //put the contact in an intent
        var intent = Intent()
        intent.putExtra("result",data)
        //set the result to success
        setResult(RESULT_OK,intent)
        //close this activity
        finish()
    }
}