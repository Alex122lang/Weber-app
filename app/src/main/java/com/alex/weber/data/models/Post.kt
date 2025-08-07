package com.alex.weber.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val name:String?,
    val description:String?,
    val image_url:String?,
    val id:Int?,
    val created_at:String?,
)
