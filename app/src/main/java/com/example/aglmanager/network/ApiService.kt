package com.example.aglmanager.network

import com.example.aglmanager.data.Login
import com.example.aglmanager.data.LoginRequest
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

private const val BASE_URL = "https://manager.agl.si/api/api/v1/"

private val client = OkHttpClient.Builder().addInterceptor { chain ->
    val request: Request = chain.request().newBuilder()
        .addHeader("Accept", "application/json")
        .build()
    chain.proceed(request)
}.build()

private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @Headers("Accept: application/json")
    @POST("auth/login")
    suspend fun login(
        @Body credentials: LoginRequest
    ): Login
}

object Api {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}