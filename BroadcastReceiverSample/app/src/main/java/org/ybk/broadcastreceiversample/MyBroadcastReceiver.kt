package org.ybk.broadcastreceiversample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import org.ybk.broadcastreceiversample.MainActivity.Companion.ACTION
import org.ybk.broadcastreceiversample.MainActivity.Companion.KEY_MSG

class MyBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra(KEY_MSG)
        if(intent?.action == ACTION) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

}