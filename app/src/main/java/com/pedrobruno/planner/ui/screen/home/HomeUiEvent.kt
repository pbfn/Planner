package com.pedrobruno.planner.ui.screen.home

sealed class HomeUiEvent {
    data object OnLoadUser : HomeUiEvent()
    data object OnLoadActivities : HomeUiEvent()

    data class OnActivityChange(val activity: String) : HomeUiEvent()
}