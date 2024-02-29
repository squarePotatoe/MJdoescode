package com.mjdoescode.mjdoescode

import android.util.Log
import androidx.lifecycle.*
import com.mjdoescode.mjdoescode.data.BlogEntryRepository
import com.mjdoescode.mjdoescode.model.BlogEntries
import kotlinx.coroutines.launch

enum class BlogApiStatus {LOADING, ERROR, DONE}
private const val TAG = "BlogViewModel"
class BlogViewModel(private val blogEntryRepository: BlogEntryRepository): ViewModel() {

    private val _status = MutableLiveData<BlogApiStatus>()
    val status: LiveData<BlogApiStatus> get() = _status

    private val _posts = MutableLiveData<List<BlogEntries>>()
    val posts: LiveData<List<BlogEntries>> get() = _posts

    init {
        getBlogEntries()
    }

    fun getBlogEntries() {
        viewModelScope.launch {
            _status.value = BlogApiStatus.LOADING
            Log.e(TAG, "getBlogEntries: ${blogEntryRepository.getBlogEntries() ?: null}", )
            try {
                _posts.value = blogEntryRepository.getBlogEntries()
                _status.value = BlogApiStatus.DONE
            } catch (e: java.lang.Exception) {
                _status.value = BlogApiStatus.ERROR
                _posts.value = listOf()
            }
        }
    }
}

class BlogViewModelFactory(private val blogEntryRepository: BlogEntryRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BlogViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return BlogViewModel(blogEntryRepository) as T
        }
        throw IllegalStateException("Unknown ViewModel class")
    }
}
