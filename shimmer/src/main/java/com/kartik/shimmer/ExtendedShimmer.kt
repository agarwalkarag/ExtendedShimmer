package com.kartik.shimmer

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Rect
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout

class ExtendedShimmer @JvmOverloads constructor(
    mContext: Context, attrs: AttributeSet? = null, defStyle: Int = 0, defStyleRes: Int = 0
) : LinearLayout(mContext, attrs, defStyle, defStyleRes) {

    inline fun <reified T : Enum<T>> TypedArray.getEnum(index: Int, default: T) =
        getInt(index, -1).let {
            if (it >= 0) enumValues<T>()[it] else default
        }

    private var shimmerVisibility: Int = 0
    private var mLayoutReference: Int = 0
    private var mChildCount: Int = 10
    private var mGridSpan: Int = 1
    private var mLineAlpha: Float = 0.6f
    private var mShimmerLayoutManager: Int = 0

    init {
        LayoutInflater.from(mContext).inflate(R.layout.shimmer_layout, this, true)

        orientation = VERTICAL

        attrs?.let {
            val typedArray = mContext.obtainStyledAttributes(
                it, R.styleable.KrtkShimmer, 0, 0
            )

            try {
                mLayoutReference = typedArray.getResourceId(
                    R.styleable.KrtkShimmer_shimmer_layout, R.layout.sample_shimmer_row
                )

                shimmerVisibility =
                    typedArray.getInteger(R.styleable.KrtkShimmer_shimmer_visibility,1)

                mChildCount = typedArray.getInteger(R.styleable.KrtkShimmer_shimmer_child_count, 10)

                mLineAlpha = typedArray.getFloat(R.styleable.KrtkShimmer_shimmer_line_alpha, 0.5f)

                mGridSpan = typedArray.getInteger(R.styleable.KrtkShimmer_shimmer_grid_span, 1)

                mShimmerLayoutManager =
                    typedArray.getInteger(R.styleable.KrtkShimmer_shimmer_layout_manager_type, 0)

                /*0-> Linear_Vertical
                1-> Linear_Horizontal
                2-> Grid*/

                setUpRecycle()
            } finally {
                typedArray.recycle()
            }
        }
    }

    private fun setUpRecycle() {
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        var adapterRecycler = ExtendedShimmerAdapter(mLayoutReference)
        when (mShimmerLayoutManager) {
            0 -> {
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                    adapter = adapterRecycler

                    addItemDecoration(
                        ExtendedSpacesItemDecoration(
                            space = 35
                        )
                    )
                }
            }
            1 -> {
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    adapter = adapterRecycler
                }
            }
            2 -> {
                recyclerView.apply {
                    layoutManager = GridLayoutManager(context, mGridSpan)
                    adapter = adapterRecycler
                }
            }
        }

        when (shimmerVisibility) {
            0 -> {
                hideShimmer()
            }
            1 -> {
                showShimmer()
            }
        }

        val dataArray = arrayListOf<String>()
        for (i in 1..mChildCount) {
            dataArray.add("0")
        }
        adapterRecycler.addData(dataArray)
    }

    fun showShimmer() {
        findViewById<ShimmerFrameLayout>(R.id.shimmer_view_container).visibility = View.VISIBLE
    }

    fun hideShimmer() {
        findViewById<ShimmerFrameLayout>(R.id.shimmer_view_container).visibility = View.GONE
    }

    inner class ExtendedSpacesItemDecoration(
        private val space:  Int = 0

    ) :
        RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect, view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.bottom = space
        }
    }
}