package com.pedrobruno.planner.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "tb_activities")
data class Activity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val description: String,
    val isDone: Boolean,
    val date: Date,
    val dateDone: Date? = null,
    val workRequestNotificationID: UUID? = null
)
