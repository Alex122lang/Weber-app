package com.alex.weber.data.repository

import com.alex.weber.data.models.Post

interface PostService {

        suspend fun createPost(post: Post): Post
        suspend fun getAllPost(): List<Post>
        suspend fun updatePost(post: Post): Post
        suspend fun insertImage(fileName: String, fileBytes: ByteArray): String?
        suspend fun deletePost(id: Int)
    }
