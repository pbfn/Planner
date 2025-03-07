package com.pedrobruno.planner.ui.screen.home

import com.pedrobruno.planner.data.model.ActivityItem

sealed class HomeUiEvent {
    data object OnLoadUser : HomeUiEvent()
    data object OnLoadActivities : HomeUiEvent()
    data object OnOpenDatePicker : HomeUiEvent()
    data object OnCloseDatePicker : HomeUiEvent()
    data object OnOpenTimePicker : HomeUiEvent()
    data object OnCloseTimePicker : HomeUiEvent()
    data object OnClickSaveActivity : HomeUiEvent()

    data class OnActivityChange(val activity: String) : HomeUiEvent()
    data class OnSelectedDate(val date: Long?) : HomeUiEvent()
    data class OnSelectedHour(val hour: String) : HomeUiEvent()
    data class OnClickDoneItem(val itemActivity: ActivityItem) : HomeUiEvent()
}