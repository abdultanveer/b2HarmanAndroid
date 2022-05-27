package com.abdul.b2harmanandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    lateinit var contactEditText: EditText
    var TAG = HomeActivity::class.java.simpleName
    lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        contactEditText = findViewById(R.id.etContact)
        btnHome = findViewById(R.id.btnHome)
        registerForContextMenu(btnHome)

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

    override fun onCreateContextMenu(menu: ContextMenu?,v: View?,menuInfo: ContextMenu.ContextMenuInfo? ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var mInflater = menuInflater;
        mInflater.inflate(R.menu.home_context_btn,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
         super.onContextItemSelected(item)
        when(item.itemId){
            R.id.miCut -> {Toast.makeText(this,"cutting",Toast.LENGTH_SHORT).show()}
            R.id.miCopy -> {showToast("copying")}
            R.id.miShare -> {showToast("sharing")}
        }
         return true
    }

    private fun showToast(s: String) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }

    }



