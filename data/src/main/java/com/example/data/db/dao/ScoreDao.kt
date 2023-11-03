package com.example.data.db.dao

import androidx.room.*
import com.example.domain.entities.local.Score
import kotlinx.coroutines.flow.Flow


@Dao
interface ScoreDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addScore(score: Score): Long

    @Query("SELECT * FROM Score")
    fun getAllScoresFlow(): Flow<List<Score>>

    @Query("SELECT * FROM Score")
    suspend fun getAllScores(): List<Score>

    @Query("DELETE  FROM user")
    suspend fun deleteAll()

}