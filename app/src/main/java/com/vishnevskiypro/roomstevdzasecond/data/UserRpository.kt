package com.vishnevskiypro.roomstevdzasecond.data

import androidx.lifecycle.LiveData

class UserRpository (private val userDao: UserDao) {
    val readAllData : LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user : User){
        userDao.addUser(user)
    }


}