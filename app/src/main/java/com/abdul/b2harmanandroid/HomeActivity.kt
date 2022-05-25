package com.abdul.b2harmanandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var abdul = Student("ansari",123,true)
        abdul.name = "ansari"
        var emp = Employee("abdul",123,false)
    }

    fun clickHandler(view: View) {
        var hIntent = Intent(this, MainActivity::class.java)
        startActivity(hIntent)
    }
}