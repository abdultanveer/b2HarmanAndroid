package com.abdul.b2harmanandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    EditText nameEditText; //declaration
    public static  String TAG = MainActivity.class.getSimpleName(); //"MainActivity"

    @Override
    protected void onCreate(Bundle savedInstanceState) { //getting created -- memory is allocated - coming out of sdcard/storage and getting into ram
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflating xml
        Log.i(TAG,"oncreate");
        nameEditText = findViewById(R.id.etName); //initialization -- getting hold of the edittext/ taking handle
       nameEditText.setOnFocusChangeListener(this);
        populateListView();
    }

    private void populateListView() {
        ListView countriesListView = findViewById(R.id.countriesLv);

        String[] countries = new String[]{"india","saudi","iran","afghanistan","india","saudi","iran","afghanistan","india","saudi","iran","afghanistan"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, //layout for each row of the listview
                        countries);
        countriesListView.setAdapter(adapter); //putting adapter into socket
    }

    @Override
    protected void onStart() { //activity is created and visible to the user
        super.onStart();
        Log.e(TAG,"onstart");
    }

    @Override //activity is going into the background -- sleep
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"onpause");
    }

    @Override //waking up -- ready to interact-- handle button clicks
    protected void onResume() {
        super.onResume();
        Log.w(TAG,"onresume");
    }

    /**
     * hibernate in windows
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG,"onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"ondestroy");

    }

    public void handleClick(View viewClicked) {
        switch (viewClicked.getId()){
            case R.id.btnSubmit:
                startHome();
                break;
            case R.id.btnDial:
                startDialer();
                break;
            case R.id.btnAlarm:
                createAlarm("b2harman",11,29);
                break;
        }

    }

    private void startDialer() {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9880979732"));
        startActivity(dialIntent);
    }

    /**
     * this will start home activity
     * get the contact from contacts
     */
    private void startHome() {
        Log.i(TAG,"starting home");
        int a =10;
        int b = 20;
        int c = 0;
        for(int i=1;i<5;i++){
             c = i + b;
        }

        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
        startActivityForResult(hIntent,123); //request code will identify what kind[contact] of request im making
       // throw new NullPointerException("main activity couldn't start home");
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * using request code you can differentiate whether the data being received is of type contact/location/image
     * @param requestCode
     * @param resultCode
     * @param intentHomeActivity
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intentHomeActivity) {
        super.onActivityResult(requestCode, resultCode, intentHomeActivity);
        Log.i(TAG,"received result from home");
        if(requestCode == 123 && resultCode == RESULT_OK){
            //get hold of tvContact
            TextView tvContact = findViewById(R.id.tvContact);
            //from the intent get the extras and string in extras with key result
            Bundle extras = intentHomeActivity.getExtras();
            String data = extras.getString("result");
            //set the string on the tvContact
            tvContact.setText(data);
        }
    }

    @Override
    public void onFocusChange(View currentViewWithFocus, boolean isFocussed) {
        if(isFocussed){
            Toast.makeText(this,  "is focussed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,  "lost focus", Toast.LENGTH_SHORT).show();

        }

    }
}

