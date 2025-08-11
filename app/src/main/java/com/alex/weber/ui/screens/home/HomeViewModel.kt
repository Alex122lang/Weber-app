package com.alex.weber.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.weber.data.models.Post
import com.alex.weber.data.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    // states
    private val _post: MutableStateFlow<List<Post>> = MutableStateFlow<List<Post>>(listOf())
    val post: StateFlow<List<Post>> get() = _post

    private val postRepository = PostRepository()

     var videos =  listOf<String>(
         "https://owrxzvligmppzoocsvut.supabase.co/storage/v1/object/public/weber/435dbbf4eb4ce7677386295dbef8f04b.png",
         "https://owrxzvligmppzoocsvut.supabase.co/storage/v1/object/public/weber/8cf5847715aa376dead99d0f575d3277.png",
         "https://owrxzvligmppzoocsvut.supabase.co/storage/v1/object/public/weber/images-22.jpg"
     )


    //    init
    init {
        getPost()
    }
    //    methods
    fun getPost(){
        viewModelScope.launch { _post.value = postRepository.getAllPost() }
    }
    fun createPlace(post: Post){
        viewModelScope.launch { postRepository.createPost(post)
            getPost()}
    }

    fun insertImage(fileName: String, fileBytes: ByteArray){
        viewModelScope.launch {
            postRepository.insertImage(fileName, fileBytes)
        }
    }
}