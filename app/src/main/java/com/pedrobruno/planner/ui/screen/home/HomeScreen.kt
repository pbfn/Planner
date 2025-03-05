package com.pedrobruno.planner.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedrobruno.planner.R
import com.pedrobruno.planner.data.model.mock.mockedListActivities
import com.pedrobruno.planner.ui.components.home_screen.BoxActivities
import com.pedrobruno.planner.ui.components.home_screen.BoxAddNewActivities
import com.pedrobruno.planner.ui.components.home_screen.TopDataUser
import com.pedrobruno.planner.ui.theme.Zinc950

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
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
                modifier = Modifier.padding(vertical = 32.dp)
            )
            BoxAddNewActivities(
                modifier = Modifier.fillMaxWidth(),
                activity = "",
                data = "",
                hour = "",
                onActivityChanged = {},
                onDataChanged = {},
                onHourChange = {},
                onSaveClick = {}
            )

            Spacer(modifier = Modifier.height(24.dp))

            BoxActivities(
                modifier = Modifier
                    .fillMaxWidth(),
                activities = mockedListActivities
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}