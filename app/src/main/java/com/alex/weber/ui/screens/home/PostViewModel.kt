package com.alex.weber.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.weber.data.models.Post
import com.alex.weber.data.repository.PostRepository
import com.alex.weber.data.repository.UploadResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    // states
    private val _posts: MutableStateFlow<List<Post>> = MutableStateFlow<List<Post>>(listOf())
    val posts: StateFlow<List<Post>> get() = _posts

    private val _post = MutableStateFlow<Post>(Post(
        "", "", ""
    ))

    private val _uploadProgress = MutableStateFlow<Float>(0f)
    val uploadProgress: StateFlow<Float> get() = _uploadProgress

    private val postRepository = PostRepository()



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