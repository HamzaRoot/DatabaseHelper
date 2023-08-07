package com.rootcoder.mvvmdemo.databasetypeconvertor

import androidx.room.TypeConverter
import java.util.*

class DatabaseTypeConverter {

    @TypeConverter
    fun fromDateToLong(date: Date):Long
    {
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(long: Long):Date
    {
        return Date(long)
    }
}