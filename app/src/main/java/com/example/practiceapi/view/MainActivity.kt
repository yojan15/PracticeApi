package com.example.practiceapi.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat 
import com.example.practiceapi.R
import com.example.practiceapi.databinding.ActivityMainBinding
import com.example.practiceapi.viewModel.GitaViewModel
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GitaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = GitaViewModel()
        viewModel.gitaListLiveData.observe(this) { gitaList ->
            if (gitaList != null && gitaList.isNotEmpty()) {
                binding.textView.text = gitaList[0].summary.en
            }
        }
        viewModel.fetchGitaChapters()
    }
}