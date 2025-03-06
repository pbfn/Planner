package com.pedrobruno.planner.ui.components.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pedrobruno.planner.ui.theme.Lime300
import com.pedrobruno.planner.ui.theme.Lime950
import com.pedrobruno.planner.ui.theme.Zinc50
import com.pedrobruno.planner.ui.theme.Zinc900
import com.pedrobruno.planner.ui.theme.Zinc950
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlannerTimePicker(
    onDateSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val currentTime = Calendar.getInstance()
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )
    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ) {
        Column(
            modifier = Modifier
                .background(Zinc950),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TimePicker(
                state = timePickerState,
                colors = TimePickerDefaults.colors(
                    clockDialColor = Zinc900,
                    clockDialSelectedContentColor = Lime950,
                    clockDialUnselectedContentColor = Zinc50,
                    selectorColor = Lime300,
                    containerColor = Zinc950,
                    periodSelectorBorderColor = Lime300,
                    periodSelectorSelectedContainerColor = Lime300,
                    periodSelectorUnselectedContainerColor = Lime300,
                    periodSelectorSelectedContentColor = Lime300,
                    periodSelectorUnselectedContentColor = Lime300,
                    timeSelectorSelectedContainerColor = Lime300,
                    timeSelectorUnselectedContainerColor = Lime300.copy(alpha = 0.6f),
                    timeSelectorSelectedContentColor = Lime950,
                    timeSelectorUnselectedContentColor = Lime950,
                )
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End)
            ) {
                TextButton(
                    onClick = {
                        onDismiss()
                    }
                ) {
                    Text(text = "Cancelar", color = Lime300)
                }
                TextButton(
                    onClick = {
                        val hour = timePickerState.hour
                        val minute = timePickerState.minute
                        onDateSelected("$hour:$minute")
                        onDismiss()
                    }
                ) {
                    Text(text = "Ok", color = Lime300)
                }
            }

        }

    }

}

@Preview
@Composable
private fun PlannerTimePickerPreview() {
    PlannerTimePicker(
        onDateSelected = {},
        onDismiss = {}
    )
}