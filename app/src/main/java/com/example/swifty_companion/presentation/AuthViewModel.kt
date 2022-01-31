package com.example.swifty_companion.presentation

import android.app.Application
import android.content.Intent
import android.util.Log
//import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.swifty_companion.R
//import com.example.swifty_companion.data.AuthRepository
import com.example.swifty_companion.tools.SingleLiveEvent
//import net.openid.appauth.AuthorizationException
//import net.openid.appauth.AuthorizationService
//import net.openid.appauth.TokenRequest

//class AuthViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val authRepository = AuthRepository()
//    private val authService = AuthorizationService(getApplication())
//    private val openAuthPageLiveEvent = SingleLiveEvent<Intent>()
//    private val authSuccessLiveEvent = SingleLiveEvent<Unit>()
//    private val toastLiveEvent = SingleLiveEvent<Int>()
//
//    val openAuthPageLiveData : LiveData<Intent>
//        get() = openAuthPageLiveEvent
//
//    val authSuccessLiveData: LiveData<Unit>
//        get() = authSuccessLiveEvent
//
//    val toastLiveData: LiveData<Int>
//        get() = toastLiveEvent
//
//    fun onAuthCodeFailed(exception: AuthorizationException) {
//        toastLiveEvent.postValue(R.string.auth_canceled)
//    }
//
//    fun onAuthCodeReceived(tokenRequest: TokenRequest) {
//        authRepository.performTokenRequest(
//            authService, tokenRequest,
//            onComplete = {
//                authSuccessLiveEvent.postValue(Unit)
//            },
//            onError = {
//                toastLiveEvent.postValue(R.string.auth_canceled)
//            }
//        )
//    }
//
//    fun openLoginPage() {
//        val customTabsIntent = CustomTabsIntent.Builder()
//            .build()
//
//        val openAuthPageIntent = authService.getAuthorizationRequestIntent(
//            authRepository.getAuthRequest(),
//            customTabsIntent
//        )
////        Log.d("mdude==", "${openAuthPageIntent.toString()}")
//        openAuthPageLiveEvent.postValue(openAuthPageIntent)
//    }

    

//}