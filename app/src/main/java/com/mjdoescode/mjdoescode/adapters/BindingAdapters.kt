package com.mjdoescode.mjdoescode.adapters

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mjdoescode.mjdoescode.BlogApiStatus
import com.mjdoescode.mjdoescode.model.BlogEntries

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<BlogEntries>?
) {
    val adapter = recyclerView.adapter as BlogPostAdapter
    adapter.submitList(data)
}

@BindingAdapter("blogApiStatus")
fun bindingStatus(
    textView: TextView,
    status: BlogApiStatus?
) {
    when (status) {
        BlogApiStatus.LOADING -> {
            textView.visibility = VISIBLE
        }
        BlogApiStatus.ERROR -> {
            textView.visibility = VISIBLE
        }
        else -> {
            textView.visibility = GONE
        }
    }
}