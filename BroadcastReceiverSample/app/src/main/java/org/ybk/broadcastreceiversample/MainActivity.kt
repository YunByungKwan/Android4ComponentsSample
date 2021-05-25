package org.ybk.broadcastreceiversample

import org.ybk.broadcastreceiversample.MyBroadcastReceiver
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ybk.broadcastreceiversample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mReceiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Databinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Send broadcast message
        binding.button.setOnClickListener {
            val intent = Intent(ACTION)
            intent.putExtra(KEY_MSG, "Broadcast!")
            sendBroadcast(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        registerBroadcastReceiver()
    }

    override fun onPause() {
        super.onPause()
        unregisterBroadcastReceiver()
    }

    // Register broadcast receiver
    private fun registerBroadcastReceiver() {
        if(mReceiver != null) {
            return
        }
        val filter = IntentFilter()
        filter.addAction(ACTION)
        mReceiver = MyBroadcastReceiver()
        registerReceiver(mReceiver, filter)
    }

    // Unregister broadcast receiver
    private fun unregisterBroadcastReceiver() {
        if(mReceiver != null) {
            unregisterReceiver(mReceiver)
            mReceiver = null
        }
    }

    companion object {
        // Broadcast action name
        const val ACTION = "org.ybk.broadcastreceiversample"

        // Intent data name
        const val KEY_MSG = "message"
    }
}