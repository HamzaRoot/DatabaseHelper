package com.rootcoder.mvvmdemo.dataaccessobject

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rootcoder.mvvmdemo.datamodels.RoomdbDM

@Dao
interface RoomdbDAO {

    @Insert
    suspend fun insertData(model: RoomdbDM)

    @Update
    suspend fun updateData(model: RoomdbDM)

    @Delete
    suspend fun deleteData(model: RoomdbDM)

    @Query("Select * FROM UserInfo")
    fun getData(): LiveData<List<RoomdbDM>>
}