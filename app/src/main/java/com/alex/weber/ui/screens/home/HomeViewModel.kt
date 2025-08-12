package com.alex.weber.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.weber.data.models.Post
import com.alex.weber.data.repository.PostRepository
import com.alex.weber.data.repository.UploadResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    // states
    private val _posts: MutableStateFlow<List<Post>> = MutableStateFlow<List<Post>>(listOf())
    val posts: StateFlow<List<Post>> get() = _posts

    private val _post = MutableStateFlow<Post>(Post(
        "", "", ""
    ))

    private val _uploadProgress = MutableStateFlow<Float>(0f)
    val uploadProgress: StateFlow<Float> get() = _uploadProgress

    private val postRepository = PostRepository()

//     var videos =  listOf<String>(
//         "https://owrxzvligmppzoocsvut.supabase.co/storage/v1/object/public/weber/capture_1754999266024.mp4",
//         "https://owrxzvligmppzoocsvut.supabase.co/storage/v1/object/public/weber/6bd7555cb4e4e695c1a28f495c8a9291_1754210251153.mp4",
//         "https://owrxzvligmppzoocsvut.supabase.co/storage/v1/object/public/weber/a26b667467284bf9ae5e242a5e05952d_1754675899995.mp4",
//         "https://owrxzvligmppzoocsvut.supabase.co/storage/v1/object/public/weber/ZAYN%20-%20Dusk%20Till%20Dawn%20(Official%20Video)%20ft.%20Sia.mp4",
//     )


    //    init
    init {
        getPost()
    }
    //    methods
    fun getPost(){
        viewModelScope.launch { _posts.value = postRepository.getAllPost() }
    }
    fun createPosts( name: String?,  description: String? ){
        viewModelScope.launch {
            _post.value = _post.value.copy(
                name=name, description = description
            )
            postRepository.createPost(_post.value)
            getPost()
        }
    }
    fun insertImage(fileName: String, fileBytes: ByteArray) {
        viewModelScope.launch {
            postRepository.insertImage(fileName, fileBytes).collect { result ->
                when (result) {
                    is UploadResult.Progress -> {
                        _uploadProgress.value = result.percent
                    }
                    is UploadResult.Success -> {
                        _post.value = _post.value.copy(image_url = result.url)
                    }
                }

            }
        }
    }
}