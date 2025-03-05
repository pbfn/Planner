package com.pedrobruno.planner.ui.components.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedrobruno.planner.data.model.ActivityItem
import com.pedrobruno.planner.data.model.mock.mockedListActivities
import com.pedrobruno.planner.ui.components.activities.PlannerActivityItem
import com.pedrobruno.planner.ui.theme.Zinc50

@Composable
fun BoxActivities(
    modifier: Modifier = Modifier,
    activities: List<ActivityItem>
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Atividades",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = Zinc50,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(
                activities
            ) { activity ->
                PlannerActivityItem(item = activity)
            }
        }
    }
}

@Preview()
@Composable
private fun BoxActivitiesPreview() {
    BoxActivities(
        activities = mockedListActivities
    )
}


