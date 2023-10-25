package com.example.domain.entities.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String = "Invitado",
    var score: Int = -1
) {
    fun myScore() = "Tu puntuaje es $score/10"

}
