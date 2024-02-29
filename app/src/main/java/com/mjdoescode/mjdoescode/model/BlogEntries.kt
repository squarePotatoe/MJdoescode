package com.mjdoescode.mjdoescode.model

import kotlinx.serialization.Serializable

@Serializable
data class BlogEntries(
    val id: String,
    val header: String,
    val content: String,
    val author: String,
    val date: String? = null
)
