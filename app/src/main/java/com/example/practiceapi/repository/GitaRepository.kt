package com.example.practiceapi.repository

import android.util.Log
import com.example.practiceapi.api.ApiService
import com.example.practiceapi.model.Gita
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitaRepository(private val apiService: ApiService) {

    fun getChapters(callBack :(Gita?)-> Unit ) {
        apiService.getChapters().enqueue(object :Callback<Gita>  {
            override fun onResponse(call: Call<Gita>, response: Response<Gita>) {
                if(response.isSuccessful) {
                    callBack(response.body())
                } else {
                    callBack(null)
                }
            }
            override fun onFailure(call: Call<Gita>, t: Throwable) {
              Log.e("repo","$t")
                callBack(null)
            }
        })
    }
}