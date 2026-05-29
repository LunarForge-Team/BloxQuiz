package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val username: String,
    val passwordHash: String,
    val nickname: String,
    val highestScore: Int = 0,
    val currentScore: Int = 0,
    val highestLevelNormal: Int = 0,
    val highestLevelHard: Int = 0,
    val highestLevelNightmare: Int = 0,
    val lastActiveTimestamp: Long = System.currentTimeMillis()
)
