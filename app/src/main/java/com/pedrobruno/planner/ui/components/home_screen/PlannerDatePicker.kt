package com.pedrobruno.planner.ui.components.home_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.ConfigurationCompat
import com.pedrobruno.planner.ui.theme.Lime300
import com.pedrobruno.planner.ui.theme.Lime950
import java.time.LocalDate
import java.time.ZoneId
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlannerDatePicker(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        modifier = Modifier.padding(20.dp),
        onDismissRequest = {
            onDismiss()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val selectedDateMillis = datePickerState.selectedDateMillis
                    val adjustedDateMillis = selectedDateMillis?.let {
                        val localDate =
                            LocalDate.ofEpochDay(it / 86400000)
                        localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()
                            .toEpochMilli()
                    }
                    onDateSelected(adjustedDateMillis)
                    onDismiss()
                }
            ) {
                Text("Ok", color = Lime300)
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismiss()
            }) {
                Text(text = "Cancelar", color = Lime300)
            }
        },
        colors = DatePickerDefaults.colors(
            containerColor = Color.Black
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        val dateFormatter = DatePickerDefaults.dateFormatter()
        val formattedDate = dateFormatter.formatDate(
            dateMillis = datePickerState.selectedDateMillis,
            locale = ConfigurationCompat.getLocales(LocalConfiguration.current).get(0)
                ?: Locale.getDefault()
        )
        val headLineText = formattedDate ?: "Selecione uma data"
        DatePicker(
            state = datePickerState,
            colors = DatePickerDefaults.colors(
                containerColor = Color.Black,
                headlineContentColor = Color.White,
                subheadContentColor = Color.Gray,
                dayContentColor = Color.White,
                todayContentColor = Color.White,
                yearContentColor = Color.LightGray,
                navigationContentColor = Color.White,
                todayDateBorderColor = Lime950,
                selectedDayContainerColor = Lime300,
                selectedDayContentColor = Lime950,
                selectedYearContainerColor = Lime300,
                selectedYearContentColor = Lime950,
            ),
            headline = {
                Row(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = headLineText,
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 25.sp),
                    )
                }
            },
            title = {
                Row(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
                    Text(
                        text = "Data da atividade",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.White,
                            fontSize = 18.sp
                        ),
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun PlannerDatePickerPreview() {
    PlannerDatePicker(
        onDateSelected = {},
        onDismiss = {}
    )
}