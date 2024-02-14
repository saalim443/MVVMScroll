package codeflies.com.mvvmscroll.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import codeflies.com.mvvmscroll.model.PostResult
import codeflies.com.mvvmscroll.model.PostResultItem
import codeflies.com.mvvmscroll.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application) : AndroidViewModel(application) {


    fun getpost(result :(List<PostResultItem>) -> Unit) {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                  ApiClient.create().getPost()
                }
            }.onSuccess {
                result.invoke(it)
                Log.e("roshan",it.toString())
            }.onFailure {
                Log.e("roshan",it.localizedMessage)
            }

        }
    }

}