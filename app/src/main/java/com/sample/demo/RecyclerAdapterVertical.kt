package com.sample.demo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.demo.databinding.RowVerticalBinding

class RecyclerAdapterVertical : RecyclerView.Adapter<RecyclerAdapterVertical.MyViewHolder>() {

    private var list: ArrayList<String> = ArrayList()
    lateinit var context: Context

    class MyViewHolder(val binding: RowVerticalBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        return MyViewHolder(
            RowVerticalBinding.inflate(
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