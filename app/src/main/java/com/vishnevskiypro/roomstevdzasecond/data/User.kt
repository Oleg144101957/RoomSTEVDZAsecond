package com.vishnevskiypro.roomstevdzasecond.data

import android.net.ipsec.ike.ChildSessionConfiguration
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class User (
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val firstName: String,
        val secondName: String,
        val age: Int

        )