package com.mjdoescode.mjdoescode.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mjdoescode.mjdoescode.databinding.GridViewItemBinding
import com.mjdoescode.mjdoescode.model.BlogEntries

class BlogPostAdapter: androidx.recyclerview.widget.ListAdapter<BlogEntries, BlogPostAdapter.BlogPostViewHolder>(
    DiffCallback
) {

    class BlogPostViewHolder(
        private val binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(blogPost: BlogEntries){
            binding.postContent.text = blogPost.subtitle
            binding.postHeader.text = blogPost.header
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<BlogEntries>() {
        override fun areItemsTheSame(oldItem: BlogEntries, newItem: BlogEntries): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BlogEntries, newItem: BlogEntries): Boolean {
            return oldItem.header == newItem.header
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogPostViewHolder {
        return BlogPostViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BlogPostViewHolder, position: Int) {
        val blogPost = getItem(position)
        holder.bind(blogPost)
    }

}