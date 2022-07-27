package com.vishnevskiypro.roomstevdzasecond.repository

import androidx.lifecycle.LiveData
import com.vishnevskiypro.roomstevdzasecond.data.UserDao
import com.vishnevskiypro.roomstevdzasecond.model.User

class UserRpository (private val userDao: UserDao) {
    val readAllData : LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user : User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }


}