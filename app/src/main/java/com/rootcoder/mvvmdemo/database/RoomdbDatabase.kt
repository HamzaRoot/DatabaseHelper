package com.rootcoder.mvvmdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.rootcoder.mvvmdemo.dataaccessobject.RoomdbDAO
import com.rootcoder.mvvmdemo.databasetypeconvertor.DatabaseTypeConverter
import com.rootcoder.mvvmdemo.datamodels.RoomdbDM

@Database(entities = [RoomdbDM::class], version = 2)
@TypeConverters(DatabaseTypeConverter::class)
abstract class RoomdbDatabase: RoomDatabase() {

    abstract fun getDAO(): RoomdbDAO

    companion object{

        val migration_1_2 = object : Migration(1,2)
        {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE UserInfo ADD COLUMN isNew INTERGER NOT NULL DEFAULT(0)")
            }

        }

        @Volatile
        private var INSTANCE:RoomdbDatabase?=null;

        fun getDatabase(context:Context):RoomdbDatabase{
            if(INSTANCE==null)
            {
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,
                        RoomdbDatabase::class.java,"roomDB")
                        .addMigrations(migration_1_2)
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}