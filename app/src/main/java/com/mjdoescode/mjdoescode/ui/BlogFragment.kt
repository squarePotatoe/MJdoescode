package com.mjdoescode.mjdoescode.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mjdoescode.mjdoescode.BlogApplication
import com.mjdoescode.mjdoescode.BlogViewModel
import com.mjdoescode.mjdoescode.BlogViewModelFactory
import com.mjdoescode.mjdoescode.adapters.BlogPostAdapter
import com.mjdoescode.mjdoescode.databinding.FragmentBlogBinding

private const val TAG = "Blog"

class BlogFragment : Fragment() {
    private lateinit var binding: FragmentBlogBinding

    private val viewModel: BlogViewModel by activityViewModels {
        BlogViewModelFactory(
            (activity?.application as BlogApplication).container.blogEntryRepository
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        Log.e(TAG, "onViewCreated: ${viewModel.status.value}", )

        binding.postsRecycler.adapter = BlogPostAdapter()
        binding.postsRecycler.layoutManager = LinearLayoutManager(requireContext())

    }

}