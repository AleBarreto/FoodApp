package com.example.foodapp.api

import com.example.foodapp.features.comments.model.Comment
import com.example.foodapp.features.menu.model.Menu
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://tradingnotification.firebaseapp.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface FoodApiService {

    @GET("menu.json")
    fun getListMenu(): Call<List<Menu>>

    @GET("comments.json")
    fun getCommentsMenu(@Query("menu_id") id: Int): Call<List<Comment>>
}

object FoodApi {
    val retrofitService: FoodApiService by lazy {
        retrofit.create(FoodApiService::class.java)
    }
}