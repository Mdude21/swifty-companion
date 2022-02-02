package com.example.swifty_companion.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Networking {
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AddToken())
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val contentType = "application/json".toMediaType()

    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.intra.42.fr")
        .client(okHttpClient)
//        .addConverterFactory(MoshiConverterFactory.create())
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    val intraApi : IntraApi
        get() = retrofit.create(IntraApi::class.java)
}