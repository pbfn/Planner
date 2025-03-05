package com.pedrobruno.planner.ui.components.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedrobruno.planner.R
import com.pedrobruno.planner.ui.components.buttons.PlannerButton
import com.pedrobruno.planner.ui.components.inputs.PlannerInput

@Composable
fun BoxAddNewActivities(
    modifier: Modifier = Modifier,
    activity: String,
    data: String,
    hour: String,
    onActivityChanged: (String) -> Unit,
    onDataChanged: (String) -> Unit,
    onHourChange: (String) -> Unit,
    onSaveClick: () -> Unit
) {

    val buttonIsEnable = data.isEmpty() && activity.isEmpty() && hour.isEmpty()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        PlannerInput(
            modifier = Modifier.fillMaxWidth(),
            value = activity,
            placeholder = "Qual a atividade?",
            leadingIcon = R.drawable.tag,
            isPassword = false,
            onValueChange = { newValue ->
                onActivityChanged(newValue)
            }
        )

        PlannerInput(
            modifier = Modifier.fillMaxWidth(),
            value = data,
            placeholder = "Qual a data?",
            leadingIcon = R.drawable.calendar,
            isPassword = false,
            onValueChange = { newValue ->
                onDataChanged(newValue)
            }
        )

        PlannerInput(
            modifier = Modifier.fillMaxWidth(),
            value = hour,
            placeholder = "Qual a hora?",
            leadingIcon = R.drawable.clock,
            isPassword = false,
            onValueChange = { newValue ->
                onHourChange(newValue)
            }
        )

        Spacer(modifier = Modifier.height(4.dp))

        PlannerButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Salvar atividade",
            disable = buttonIsEnable,
            onClick = {
                onSaveClick()
            }
        )
    }
}

@Preview(name = "Empty state", showBackground = true)
@Composable
private fun BoxAddNewActivitiesPreview0() {
    BoxAddNewActivities(
        activity = "",
        data = "",
        hour = "",
        onActivityChanged = {},
        onDataChanged = {},
        onHourChange = {},
        onSaveClick = {}
    )
}

@Preview(name = "Default state", showBackground = true)
@Composable
private fun BoxAddNewActivitiesPreview1() {
    BoxAddNewActivities(
        activity = "Correr",
        data = "20 de agosto",
        hour = "08:00",
        onActivityChanged = {},
        onDataChanged = {},
        onHourChange = {},
        onSaveClick = {}
    )
}