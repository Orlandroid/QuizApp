package com.example.data.local


import com.example.data.db.dao.ScoreDao
import com.example.data.db.dao.UserDao
import com.example.domain.LocalDataSource
import com.example.domain.entities.local.Score

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSourceImpl @Inject constructor(
    private val userDao: UserDao,
    private val scoreDao: ScoreDao
) : LocalDataSource {
    override suspend fun saveScore(score: Score) = scoreDao.addScore(score)
    override suspend fun getAllScores() = scoreDao.getAllScores()

}
