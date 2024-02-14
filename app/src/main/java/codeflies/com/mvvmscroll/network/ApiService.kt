package codeflies.com.mvvmscroll.network

import codeflies.com.mvvmscroll.model.PostResult
import codeflies.com.mvvmscroll.model.PostResultItem
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPost(): List<PostResultItem>
}