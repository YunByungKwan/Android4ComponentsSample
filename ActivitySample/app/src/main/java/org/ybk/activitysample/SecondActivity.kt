package org.ybk.activitysample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ybk.activitysample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goMainButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.goThirdButton.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        binding.goFourthButton.setOnClickListener {
            startActivity(Intent(this, FourthActivity::class.java))
        }
    }
}