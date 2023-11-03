package com.example.data.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.dao.ScoreDao
import com.example.data.db.dao.UserDao
import com.example.domain.entities.local.Score
import com.example.domain.entities.local.User


@Database(entities = [User::class, Score::class], version = 2, exportSchema = false)

abstract class MainDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun scoreDao(): ScoreDao

}