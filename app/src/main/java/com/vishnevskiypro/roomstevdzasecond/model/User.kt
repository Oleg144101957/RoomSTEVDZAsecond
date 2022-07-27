package com.vishnevskiypro.roomstevdzasecond.model

import android.net.ipsec.ike.ChildSessionConfiguration
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class User (
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val firstName: String,
        val secondName: String,
        val age: Int

        ) : Parcelable