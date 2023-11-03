package com.example.domain

import com.example.domain.entities.local.Score


interface LocalDataSource {

    suspend fun saveScore(score: Score): Long

    suspend fun getAllScores(): List<Score>
}