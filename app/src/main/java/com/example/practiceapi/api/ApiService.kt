package com.example.practiceapi.api

import com.example.practiceapi.model.Gita
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("chapters")
    fun getChapters() : Call<Gita>
}