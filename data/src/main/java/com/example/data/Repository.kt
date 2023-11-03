package com.example.data


import com.example.domain.LocalDataSource
import com.example.domain.RemoteDataSource
import com.example.domain.entities.local.Score
import javax.inject.Inject


class Repository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getUser() = remoteDataSource.getUser()
    suspend fun saveScore(score: Score) = localDataSource.saveScore(score)
    suspend fun getAllScore() = localDataSource.getAllScores()
}