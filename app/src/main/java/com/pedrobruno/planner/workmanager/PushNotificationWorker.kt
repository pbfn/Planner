package com.pedrobruno.planner.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.pedrobruno.planner.R

class PushNotificationWorker(
    context: Context,
    workerParams: WorkerParameters
) :
    Worker(context, workerParams) {

    private val activity: String = workerParams.inputData.getString("activity") ?: ""

    override fun doWork(): Result {

        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "default_channel",
                "Default Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }
        val notification = NotificationCompat.Builder(applicationContext, "default_channel")
            .setSmallIcon(R.drawable.logoicon)
            .setContentTitle("Uma nova tarefa para hoje")
            .setContentText(activity)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(1, notification)
        return Result.success()
    }
}