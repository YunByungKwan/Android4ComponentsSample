package org.ybk.servicesample

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log
import java.lang.Exception

class MyService: Service() {

    val mBinder = MyBinder()
    inner class MyBinder: Binder() {
        fun getService(): MyService {
            return this@MyService
        }
    }

    fun getData(): String {
        return "Hello World!"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("TAG", "[Service] Call onCreate()")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("TAG", "[Service] Call onStartCommand()")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d("TAG", "[Service] Call onBind()")
        return mBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("TAG", "[Service] Call onBind()")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.d("TAG", "[Service] Call onDestroy()")
        super.onDestroy()
    }
}