package com.sample.demo

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.sample.demo.databinding.ActivityOneBinding
import com.sample.demo.databinding.ActivityTwoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration.Companion.seconds

class ActivityTypeTwo : AppCompatActivity() {

    var arrayData = arrayListOf("1", "2", "3", "4", "5")
    var dataAdapter = RecyclerAdapterVertical()
    private lateinit var binding: ActivityTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.recyclerView.apply {
            adapter = dataAdapter
        }

        binding.shimmer.showShimmer()

        Handler().postDelayed({
            dataAdapter.addData(arrayData)
            binding.shimmer.hideShimmer()
        }, 2000)

    }
}