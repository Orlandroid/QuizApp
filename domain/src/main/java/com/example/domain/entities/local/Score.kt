package com.example.domain.entities.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Score(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val puntuacion: Int
)
