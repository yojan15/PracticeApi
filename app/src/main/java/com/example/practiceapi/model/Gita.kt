package com.example.practiceapi.model

data class Gita (
    val summary: Meaning,
    val meaning: Meaning,
    val chapterNumber: Long,
    val versesCount: Long,
    val name: String,
    val translation: String,
    val transliteration: String
)

data class Meaning (
    val hi: String,
    val en: String
)
