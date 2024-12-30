package com.example.aglmanager.network

import com.example.aglmanager.UserStore
import com.example.aglmanager.data.Login
import com.example.aglmanager.data.LoginRequest
import com.example.aglmanager.data.EventResponse
import com.example.aglmanager.data.EventsResponse
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
import retrofit2.http.QueryMap
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://manager.agl.si/api/api/v1/"

private val client = OkHttpClient.Builder().addInterceptor { chain ->
    val originalRequest = chain.request()
    val request = originalRequest.newBuilder()
        .addHeader("Accept", "application/json")
        .apply {
            UserStore.accessToken?.let { token ->
                addHeader("Authorization", "Bearer $token")
            }
        }
        .build()
    chain.proceed(request)
}.build()

private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @POST("auth/login")
    suspend fun login(
        @Body credentials: LoginRequest
    ): Login

    @GET("events")
    suspend fun getEvents(
        @QueryMap params: Map<String, String> = mapOf("include" to "users")
    ): EventsResponse

    @GET("events/{id}?include=client,charge,creator,location,users,equipment,professionRequirements")
    suspend fun getEventDetails(
        @Path("id") id: Int
    ): EventResponse
}

object Api {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}