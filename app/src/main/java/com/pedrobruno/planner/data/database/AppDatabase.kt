package com.pedrobruno.planner.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pedrobruno.planner.data.database.dao.ActivityDao
import com.pedrobruno.planner.data.database.model.Activity

@Database(entities = [Activity::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun activityDao(): ActivityDao
}