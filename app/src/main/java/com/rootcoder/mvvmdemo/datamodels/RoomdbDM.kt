package com.rootcoder.mvvmdemo.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "UserInfo")
data class RoomdbDM(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name:String,
    val age:Int,
    val gender:Boolean,
    var date:Date,
    val isNew:Int
)
