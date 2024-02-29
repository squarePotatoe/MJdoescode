package com.mjdoescode.mjdoescode.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BlogEntries(
    val id: String,
    val header: String,
    val subtitle: String,
    val content: String,
    val category: String,
    val author: String,
    val date: String? = null,
    @SerialName(value = "view_count")
    val viewCount: String? = null,
    @SerialName(value = "is_featured")
    val isFeatured: String? = null,
    @SerialName(value = "image_path")
    val imagePath: String? = null
)
