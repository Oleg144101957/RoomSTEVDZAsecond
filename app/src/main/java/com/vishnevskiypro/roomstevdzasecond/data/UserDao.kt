package com.vishnevskiypro.roomstevdzasecond.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vishnevskiypro.roomstevdzasecond.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Update
    fun updateUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<User>>




}