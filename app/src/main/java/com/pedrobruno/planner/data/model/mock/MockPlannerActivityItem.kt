package com.pedrobruno.planner.data.model.mock

import com.pedrobruno.planner.data.model.ActivityItem

val mockedListActivities = listOf(
    ActivityItem(
        description = "Academia em grupo",
        isDone = true,
        data = "sábado, dia 18 às 08:00h"
    ),
    ActivityItem(
        description = "Almoço",
        isDone = true,
        data = "sábado, dia 18 às 12:00h"
    ),
    ActivityItem(
        description = "Gaming session",
        isDone = true,
        data = "domingo, dia 19 às 18:00h"
    ),
    ActivityItem(
        description = "Jantar",
        isDone = true,
        data = "segunda, dia 20 às 21:00h"
    ),
)