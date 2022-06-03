package com.abdul.b2harmanandroid

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MusicService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"service-oncreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         super.onStartCommand(intent, flags, startId)
      // if (intent.extras != null) //null check
        var musicFileName = intent?.extras?.getString("musicname")
        Log.i(TAG,"service-onStartCommand - playing--"+musicFileName)
        var musicPlayer = MediaPlayer.create(this,R.raw.sample)
        musicPlayer.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service--onDestroy")

    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    companion object {
        var TAG = MusicService::class.java.simpleName
    }
}