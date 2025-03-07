package com.pedrobruno.planner.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tb_activities")
data class Activity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val description: String,
    val isDone: String,
    val date: Date,
    val dateDone: Date? = null
)
