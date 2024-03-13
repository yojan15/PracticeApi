package com.example.practiceapi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practiceapi.api.ApiService
import com.example.practiceapi.model.Gita
import com.example.practiceapi.repository.GitaRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitaViewModel : ViewModel() {
    private val gitaRepository: GitaRepository = GitaRepository(createApiService())
    val gitaListLiveData: MutableLiveData<List<Gita>> by lazy {
        MutableLiveData<List<Gita>>()
    }
    fun fetchGitaChapters() {
        gitaRepository.getChapters { gitaList ->
            gitaListLiveData.value = gitaList
        }
    }
    private fun createApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://bhagavadgitaapi.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}