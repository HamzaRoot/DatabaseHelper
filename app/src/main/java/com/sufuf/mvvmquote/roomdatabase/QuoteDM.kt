package com.sufuf.mvvmquote.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class QuoteDM (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val text:String,
    val author:String
)
