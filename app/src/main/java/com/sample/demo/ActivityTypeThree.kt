package com.sample.demo

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.sample.demo.databinding.ActivityOneBinding
import com.sample.demo.databinding.ActivityThreeBinding
import com.sample.demo.databinding.ActivityTwoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration.Companion.seconds

class ActivityTypeThree : AppCompatActivity() {

    var arrayData = arrayListOf("1", "2", "3", "4", "5")
    var dataAdapter = RecyclerAdapterGrid()
    private lateinit var binding: ActivityThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.recyclerView.apply {
            adapter = dataAdapter
            layoutManager = GridLayoutManager(this@ActivityTypeThree, 3)
        }

        binding.shimmer.showShimmer()

        Handler().postDelayed({
            dataAdapter.addData(arrayData)
            binding.shimmer.hideShimmer()
        }, 2000)

    }
}