package com.abdul.b2harmanandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    lateinit var contactEditText: EditText
    var TAG = HomeActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        contactEditText = findViewById(R.id.etContact)
        Log.i(TAG,"home activity created")
    }

    fun clickHandler(view: View) {
        //get the contact from the edittext
        var data = contactEditText.text.toString()
        Log.i(TAG,"setting the result --"+ data)

        //put the contact in an intent
        var intent = Intent()
        intent.putExtra("result",data)
        //set the result to success
        setResult(RESULT_OK,intent)
        //close this activity
        finish()

    }
     //developer is interested in making things work asap
    //to make things fool proof
    fun add( a:Int,  b:Int):Int {
        return a+b
    }
}