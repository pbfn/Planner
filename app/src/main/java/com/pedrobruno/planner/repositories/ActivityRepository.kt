package com.pedrobruno.planner.repositories

import android.content.Context
import android.util.Log
import androidx.sqlite.db.SimpleSQLiteQuery
import com.pedrobruno.planner.data.database.dao.ActivityDao
import com.pedrobruno.planner.data.database.model.Activity
import com.pedrobruno.planner.data.model.ActivityItem
import com.pedrobruno.planner.util.converters.data.formatarData
import com.pedrobruno.planner.util.converters.data.formatarHora
import com.pedrobruno.planner.util.converters.data.gerarDate
import com.pedrobruno.planner.workmanager.cancelWorkerNotification
import com.pedrobruno.planner.workmanager.scheduleNotificationActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActivityRepository @Inject constructor(
    private val activityDao: ActivityDao,
    @ApplicationContext private val context: Context,
) {

    private val TAG = "ActivityRepository"

    suspend fun addActivity(activityItem: ActivityItem): Boolean {
        try {
            val date = gerarDate(activityItem.data, activityItem.hour)
            if (date != null) {
                val workRequestNotificationID = scheduleNotificationActivity(
                    activity = activityItem.description,
                    date = date,
                    context = context
                )
                val activity = Activity(
                    description = activityItem.description,
                    isDone = activityItem.isDone,
                    date = date,
                    workRequestNotificationID = workRequestNotificationID
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
        cancelWorkerNotification(context = context, workId = getWorkerId(id))
    }

    fun getWorkerId(id: Int): UUID {
        val sql = "SELECT workRequestNotificationID FROM tb_activities WHERE id = $id"
        val query = SimpleSQLiteQuery(sql)
        return activityDao.getWorkerId(query)
    }
}