package com.pedrobruno.planner.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedrobruno.planner.R
import com.pedrobruno.planner.data.model.mock.mockedListActivities
import com.pedrobruno.planner.ui.components.home_screen.BoxActivities
import com.pedrobruno.planner.ui.components.home_screen.BoxAddNewActivities
import com.pedrobruno.planner.ui.components.home_screen.PlannerDatePicker
import com.pedrobruno.planner.ui.components.home_screen.PlannerTimePicker
import com.pedrobruno.planner.ui.components.home_screen.TopDataUser
import com.pedrobruno.planner.ui.screen.home.HomeUiEvent.*
import com.pedrobruno.planner.ui.theme.Zinc950

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit
) {

    LaunchedEffect(Unit) {
        onEvent(OnLoadUser)
        onEvent(OnLoadActivities)
    }

    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Zinc950
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo"
            )
            TopDataUser(
                modifier = Modifier.padding(vertical = 32.dp),
                user = state.user
            )
            BoxAddNewActivities(
                modifier = Modifier.fillMaxWidth(),
                activity = state.activity,
                data = state.data,
                hour = state.hour,
                onActivityChanged = { newActivityValue ->
                    onEvent(OnActivityChange(newActivityValue))
                },
                onClickData = {
                    onEvent(OnOpenDatePicker)
                },
                onClickHour = {
                    onEvent(OnOpenTimePicker)
                },
                onSaveClick = {
                    onEvent(OnClickSaveActivity)
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            BoxActivities(
                modifier = Modifier
                    .fillMaxWidth(),
                activities = state.listActivities,
                onClickDoneItem ={ item->
                    onEvent(OnClickDoneItem(item))
                }
            )
        }
        if (state.showDatePicker) {
            PlannerDatePicker(
                onDateSelected = { date ->
                    onEvent(OnSelectedDate(date))
                },
                onDismiss = {
                    onEvent(OnCloseDatePicker)
                }
            )
        }
        if (state.showTimePicker) {
            PlannerTimePicker(
                onDateSelected = { hour ->
                    onEvent(OnSelectedHour(hour))
                },
                onDismiss = {
                    onEvent(OnCloseTimePicker)
                }
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen(
        state = HomeUiState(
            listActivities = mockedListActivities,
        ),
        onEvent = {}
    )
}