package com.vishnevskiypro.roomstevdzasecond.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vishnevskiypro.roomstevdzasecond.data.UserDatabase
import com.vishnevskiypro.roomstevdzasecond.repository.UserRpository
import com.vishnevskiypro.roomstevdzasecond.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    private val repository: UserRpository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRpository(userDao)
        readAllData = repository.readAllData
    }


    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateUser(user)
        }
    }

}