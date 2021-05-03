package org.ybk.servicesample

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import org.ybk.servicesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myService: MyService? = null
    private var isService = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, MyService::class.java)
        val serviceConnection = object: ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.d("TAG", "Call onServiceConnected()")
                val binder = service as MyService.MyBinder
                myService = binder.getService()
                isService = true
                binding.statusText.text = "status: bind"
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                Log.d("TAG", "Call onServiceDisconnected()")
                isService = false
                binding.statusText.text = "status: Not bind"
            }
        }
        binding.bindServiceButton.setOnClickListener {
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }
        binding.unbindServiceButton.setOnClickListener {
            if(isService) {
                unbindService(serviceConnection)
                isService = false
                binding.statusText.text = "status: Not bind"
            }
        }
        binding.getDataButton.setOnClickListener {
            if(isService) {
                binding.textView.text = myService?.getData()
            } else {
                binding.textView.text = "Please bind service"
            }
        }
    }
}