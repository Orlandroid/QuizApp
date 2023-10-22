package com.example.domain.entities.local

import androidx.annotation.DrawableRes

data class Question(
    @DrawableRes
    val backgroundQuestions: Int,
    val question: String,
    val correctAnswerId: Int,
    val answers: List<Answer>,
)

data class Answer(
    val id: Int,
    val answer: String,
)
