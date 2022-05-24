package com.abdul.b2harmanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var abdul = Student("ansari",123,true)
        abdul.name = "ansari"
        var emp = Employee("abdul",123,false)
    }
}