package org.ybk.activitysample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ybk.activitysample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goSecondButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding.goThirdButton.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        binding.goFourthButton.setOnClickListener {
            startActivity(Intent(this, FourthActivity::class.java))
        }
    }
}