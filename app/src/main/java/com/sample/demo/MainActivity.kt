package com.sample.demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.sample.demo.databinding.ActivityMainBinding
import java.net.URI

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var deviceId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.type1.setOnClickListener {
            startActivity(Intent(this, ActivityTypeOne::class.java))
        }

        binding.type2.setOnClickListener {
            startActivity(Intent(this, ActivityTypeTwo::class.java))
        }

        binding.type3.setOnClickListener {
            startActivity(Intent(this, ActivityTypeThree::class.java))
        }
        binding.type4.setOnClickListener {
            startActivity(Intent(this, ActivityTypeFour::class.java))
        }
    }
}