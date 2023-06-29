package com.sample.demo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.demo.databinding.RowDefaultBinding
import com.sample.demo.databinding.RowVerticalBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private var list: ArrayList<String> = ArrayList()
    lateinit var context: Context

    class MyViewHolder(val binding: RowDefaultBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        return MyViewHolder(
            RowDefaultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder.binding)
        {
            var data = list.get(position)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addData(list: ArrayList<String>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        list.clear()
    }
}