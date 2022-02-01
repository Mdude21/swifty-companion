package com.example.swifty_companion.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.swifty_companion.data.model.User
import com.example.swifty_companion.data.repository.SearchRepository
import kotlinx.coroutines.Job

class SearchViewModel : ViewModel() {

    private val repository = SearchRepository()

    private var currentInfoJob: Job? = null

    private val userLiveData = MutableLiveData<User>()

    val user: LiveData<User>
        get() = userLiveData

    fun getUserByLogin(login: String){
        currentInfoJob?.cancel()

    }

}