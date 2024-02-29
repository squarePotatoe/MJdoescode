package com.mjdoescode.mjdoescode.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mjdoescode.mjdoescode.network.BlogApiService
import com.squareup.moshi.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val blogEntryRepository: BlogEntryRepository
}

class DefaultAppContainer: AppContainer {

    private val baseUrl = "https://mjdoescode.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(kotlinx.serialization.json.Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: BlogApiService by lazy {
        retrofit.create(BlogApiService::class.java)
    }

    override val blogEntryRepository: BlogEntryRepository by lazy {
        NetworkBlogEntriesRepository(retrofitService)
    }
}