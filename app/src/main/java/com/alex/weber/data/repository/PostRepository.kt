package com.alex.weber.data.repository

import com.alex.weber.data.models.Post
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.UploadStatus
import io.github.jan.supabase.storage.storage
import io.github.jan.supabase.storage.uploadAsFlow
import io.ktor.websocket.WebSocketDeflateExtension.Companion.install


class PostRepository: PostService {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://owrxzvligmppzoocsvut.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im93cnh6dmxpZ21wcHpvb2NzdnV0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTQzOTMyNjQsImV4cCI6MjA2OTk2OTI2NH0.TXLrYSQQpO8F7P76BxvZVqaFIolekftqFHEp9SPBN-A"
    ) {
        install(Auth)
        install(Postgrest)
        install(Storage)
        //install other modules
    }

    override suspend fun createPost(post: Post): Post {
        TODO()
    }

    override suspend fun getAllPost(): List<Post> {
        return  supabase.from("posts").select().decodeList()
    }

    override suspend fun updatePost(post: Post): Post {
        TODO()

    }

    override suspend fun insertImage(
        fileName: String,
        fileBytes: ByteArray
    ): String? {
        val bucket = supabase.storage.from("weber")
        var uploadedUrl: String? = null

        bucket.uploadAsFlow(fileName, fileBytes).collect { status ->
            when (status) {
                is UploadStatus.Progress -> {
                    val percent = status.totalBytesSend.toFloat() / status.contentLength * 100
                    println("Progress: $percent%")
                }
                is UploadStatus.Success -> {
                    println("Upload successful!")
                    uploadedUrl = bucket.publicUrl(fileName)
                }
            }
        }

        return uploadedUrl
    }

    override suspend fun deletePost(id: Int) {
        TODO()

    }

}