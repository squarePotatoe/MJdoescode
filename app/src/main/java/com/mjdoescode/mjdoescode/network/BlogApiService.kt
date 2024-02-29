package com.mjdoescode.mjdoescode.network

import com.mjdoescode.mjdoescode.model.BlogEntries
import retrofit2.http.GET

private const val BASE_URL = "https://mjdoescode.com/"

interface BlogApiService {
    @GET("info")
    suspend fun getBlog(): List<BlogEntries>
}
