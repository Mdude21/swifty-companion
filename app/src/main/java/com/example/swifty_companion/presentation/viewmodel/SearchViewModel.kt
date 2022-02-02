package com.example.swifty_companion.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swifty_companion.data.AuthConfig
import com.example.swifty_companion.data.model.User
import com.example.swifty_companion.data.repository.SearchRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val repository = SearchRepository()

    private var currentInfoJob: Job? = null

    private val userLiveData = MutableLiveData<User>()

    private val defaultUser = User(0, "Error", "qwe", " asd", "we", "zxc")

    val user: LiveData<User>
        get() = userLiveData

    fun getUserByLogin(login: String){
        currentInfoJob?.cancel()

        currentInfoJob = viewModelScope.launch {
            runCatching {
                repository.getUserByLogin(login)
            }
                .onSuccess{
                    userLiveData.postValue(it)
                    AuthConfig.User = it
                    Log.d("mdude", "${it}")
                }
                .onFailure {
                    Log.d("mdude", "${it}")
                    userLiveData.postValue(defaultUser)


                }
        }
    }

}