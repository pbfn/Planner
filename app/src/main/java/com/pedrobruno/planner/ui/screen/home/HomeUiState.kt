package com.pedrobruno.planner.ui.screen.home

import com.pedrobruno.planner.data.model.ActivityItem
import com.pedrobruno.planner.data.model.User
import com.pedrobruno.planner.data.model.mock.mockedUser

data class HomeUiState(
    val user: User = mockedUser,
    val activity: String = "",
    val data: String = "",
    val hour: String = "",
    val listActivities: List<ActivityItem> = emptyList()
)
