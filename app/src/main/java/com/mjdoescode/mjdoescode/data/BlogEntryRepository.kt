package com.mjdoescode.mjdoescode.data

import com.mjdoescode.mjdoescode.network.BlogApiService
import com.mjdoescode.mjdoescode.model.BlogEntries

interface BlogEntryRepository {
    suspend fun getBlogEntries(): List<BlogEntries>
}

class NetworkBlogEntriesRepository(
    private val blogApiService: BlogApiService
    ) : BlogEntryRepository {
    override suspend fun getBlogEntries(): List<BlogEntries> = blogApiService.getBlog()
}