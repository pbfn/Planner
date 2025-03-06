package com.pedrobruno.planner.ui.screen.home

sealed class HomeUiEvent {
    data object OnLoadUser : HomeUiEvent()
    data object OnLoadActivities : HomeUiEvent()
    data object OnOpenDatePicker : HomeUiEvent()
    data object OnCloseDatePicker : HomeUiEvent()

    data class OnActivityChange(val activity: String) : HomeUiEvent()
    data class OnSelectedDate(val date: Long?) : HomeUiEvent()
}