package com.abdul.b2harmanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflating xml
        nameEditText = findViewById(R.id.etName); //initialization -- getting hold of the edittext/ taking handle
        Employee ansari = new Employee("abdul", 123, true);
        ansari.seteName("abdul");
        Student abdul = new Student("ansari", 123, true);
    }

    public void handleClick(View view) {
        String name = nameEditText.getText().toString();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(hIntent);
    }
}

