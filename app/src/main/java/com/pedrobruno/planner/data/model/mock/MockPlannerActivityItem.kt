package com.pedrobruno.planner.data.model.mock

import com.pedrobruno.planner.data.model.ActivityItem

val mockedListActivities = listOf(
    ActivityItem(
        description = "Academia em grupo",
        isDone = true,
        data = "sab, 18",
        hour = "08:00"
    ),
    ActivityItem(
        description = "Almoço",
        isDone = true,
        data = "sab, 18",
        hour = "12:00"
    ),
    ActivityItem(
        description = "Gaming session",
        isDone = true,
        data = "dom, 19",
        hour = "18:00"
    ),
    ActivityItem(
        description = "Jantar",
        isDone = false,
        data = "seg, 20",
        hour = "21:00"
    ),
)