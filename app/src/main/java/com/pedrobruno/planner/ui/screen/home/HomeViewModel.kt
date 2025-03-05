package com.pedrobruno.planner.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrobruno.planner.data.model.ActivityItem
import com.pedrobruno.planner.data.model.User
import com.pedrobruno.planner.data.model.mock.mockedListActivities
import com.pedrobruno.planner.data.model.mock.mockedUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState()
    )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onEvent(event: HomeUiEvent) {
        when (event) {
            HomeUiEvent.OnLoadUser -> onLoadUser()
            HomeUiEvent.OnLoadActivities -> onLoadActivities()
            is HomeUiEvent.OnActivityChange -> onActivityChange(event.activity)
        }
    }

    private fun onLoadActivities() {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                currentUiState.copy(
                    listActivities = loadActivitiesFromRepository()
                )
            }
        }
    }

    private fun loadActivitiesFromRepository(): List<ActivityItem> {
        //FUTURAMENTE BUSCAR DO BANCO
        return mockedListActivities
    }

    private fun onLoadUser() {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                currentUiState.copy(
                    user = loadUserFromRepository()
                )
            }
        }
    }

    private fun loadUserFromRepository(): User {
        return mockedUser
    }

    private fun onActivityChange(newValue: String) {
        viewModelScope.launch {
            _uiState.update { currentUiState ->
                currentUiState.copy(
                    activity = newValue
                )
            }
        }
    }

}