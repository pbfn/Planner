package com.pedrobruno.planner.repositories

import android.util.Log
import com.pedrobruno.planner.data.database.dao.ActivityDao
import com.pedrobruno.planner.data.database.model.Activity
import com.pedrobruno.planner.data.model.ActivityItem
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
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

    private fun gerarDate(data: String, hora: String): Date? {
        val formato = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        return formato.parse("$data $hora")
    }


}