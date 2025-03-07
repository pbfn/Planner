package com.pedrobruno.planner.data.model

data class ActivityItem(
    val id: Int = -1,
    val description: String,
    val isDone: Boolean,
    val data: String,
    val hour: String,
)