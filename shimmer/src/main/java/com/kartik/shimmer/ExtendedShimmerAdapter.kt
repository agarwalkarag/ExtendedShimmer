package com.kartik.shimmer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.RecyclerView

class ExtendedShimmerAdapter(layoutReference: Int) :
    RecyclerView.Adapter<ExtendedShimmerAdapter.CustomViewHolder>() {

    private var list: ArrayList<String> = ArrayList()
    var layoutRef = 0

    init {
        this.layoutRef = layoutReference
    }

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CustomViewHolder {
        var rootView = LayoutInflater.from(viewGroup.context).inflate(layoutRef, null)

        val windowManager =
            viewGroup.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        rootView.setLayoutParams(
            RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
            )
        )

        return CustomViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

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