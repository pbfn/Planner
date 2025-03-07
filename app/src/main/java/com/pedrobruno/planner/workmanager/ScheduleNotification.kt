package com.pedrobruno.planner.workmanager

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import java.util.Date
import java.util.UUID
import java.util.concurrent.TimeUnit

fun scheduleNotificationActivity(activity: String, date: Date, context: Context): UUID {
    val delay = date.time - System.currentTimeMillis()
    val data = workDataOf("activity" to activity)
    val workRequest = OneTimeWorkRequestBuilder<PushNotificationWorker>()
        .setInputData(data)
        .setInitialDelay(delay, TimeUnit.MILLISECONDS)
        .build()
    WorkManager.getInstance(context).enqueue(workRequest)
    return workRequest.id
}

fun cancelWorkerNotification(context: Context, workId: UUID) {
    WorkManager.getInstance(context).cancelWorkById(workId)
}