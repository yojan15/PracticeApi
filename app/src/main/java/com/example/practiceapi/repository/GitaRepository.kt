package com.example.practiceapi.repository

import android.util.Log
import com.example.practiceapi.api.ApiService
import com.example.practiceapi.model.Gita
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitaRepository(private val apiService: ApiService) {

    fun getChapters(callBack: (List<Gita>?) -> Unit) {
        apiService.getChapters().enqueue(object : Callback<List<Gita>> {
            override fun onResponse(call: Call<List<Gita>>, response: Response<List<Gita>>) {
                if (response.isSuccessful) {
                    callBack(response.body())
                } else {
                    callBack(null)
                }
            }
            override fun onFailure(call: Call<List<Gita>>, t: Throwable) {
                Log.e("repo", "$t")
                callBack(null)
            }
        })
    }
}
