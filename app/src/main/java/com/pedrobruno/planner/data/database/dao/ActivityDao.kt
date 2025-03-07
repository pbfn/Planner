package com.pedrobruno.planner.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.pedrobruno.planner.data.database.model.Activity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface ActivityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivity(activity: Activity): Long

    @RawQuery(observedEntities = [Activity::class])
    fun getActivities(query: SupportSQLiteQuery): Flow<List<Activity>>

    @Query("UPDATE tb_activities SET isDone = 1, dateDone = :dateDone WHERE id = :id")
    fun doneItem(id: Int, dateDone: Long)

    @RawQuery
    fun getWorkerId(query: SupportSQLiteQuery): UUID
}