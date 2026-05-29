package com.example.data

import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    
    val leaderboard: Flow<List<User>> = userDao.getAllUsersOrderedByScore()

    fun observeUser(username: String): Flow<User?> {
        return userDao.observeUserByUsername(username)
    }

    suspend fun getUserByUsername(username: String): User? {
        return userDao.getUserByUsername(username)
    }

    suspend fun registerUser(user: User): Boolean {
        return try {
            val existing = userDao.getUserByUsername(user.username)
            if (existing != null) {
                false
            } else {
                userDao.insertUser(user)
                true
            }
        } catch (e: Exception) {
            false
        }
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }
}
