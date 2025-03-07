package com.pedrobruno.planner.repositories

import android.util.Log
import androidx.sqlite.db.SimpleSQLiteQuery
import com.pedrobruno.planner.data.database.dao.ActivityDao
import com.pedrobruno.planner.data.database.model.Activity
import com.pedrobruno.planner.data.model.ActivityItem
import com.pedrobruno.planner.util.converters.data.formatarData
import com.pedrobruno.planner.util.converters.data.formatarHora
import com.pedrobruno.planner.util.converters.data.gerarDate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActivityRepository @Inject constructor(
    private val activityDao: ActivityDao
) {

    private val TAG = "ActivityRepository"

    suspend fun addActivity(activityItem: ActivityItem): Boolean {
        try {
            val date = gerarDate(activityItem.data, activityItem.hour)
            if (date != null) {
                val activity = Activity(
                    description = activityItem.description,
                    isDone = activityItem.isDone,
                    date = date
                )
                val idInserido = activityDao.insertActivity(
                    activity = activity
                )
                Log.d(TAG, "ID inserido: $idInserido")
                return idInserido > 0
            }
        } catch (e: Exception) {
            Log.d(TAG, "addActivity: ${e.message}")
            return false
        }
        return false
    }

    fun getActivities(): Flow<List<ActivityItem>> {
        val sql = "SELECT * FROM tb_activities ORDER BY DATE ASC"
        val query = SimpleSQLiteQuery(sql)
        return activityDao.getActivities(query).map { lista ->
            lista.map { activity ->
                ActivityItem(
                    id = activity.id,
                    description = activity.description,
                    isDone = activity.isDone,
                    data = formatarData(activity.date),
                    hour = formatarHora(activity.date)
                )
            }
        }
    }

    fun doneItem(id: Int) {
        val dateDone = Date().time
        activityDao.doneItem(id = id, dateDone = dateDone)
    }
}