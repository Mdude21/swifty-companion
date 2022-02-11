package com.example.swifty_companion.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.swifty_companion.data.AuthConfig

class InfoViewModel : ViewModel() {

    private val levelLiveData = MutableLiveData<Double>()

    val level: LiveData<Double>
        get() = levelLiveData

    fun getLevel() {
        if (AuthConfig.User?.cursUsers?.size == 1)
            levelLiveData.postValue(AuthConfig.User?.cursUsers!![0].level)
        else
            levelLiveData.postValue(AuthConfig.User?.cursUsers!![1].level)
    }

}