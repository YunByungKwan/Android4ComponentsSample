package org.ybk.activitysample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ybk.activitysample.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goMainButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

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