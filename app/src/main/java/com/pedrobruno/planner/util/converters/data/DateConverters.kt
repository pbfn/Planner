package com.pedrobruno.planner.util.converters.data

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

fun gerarDate(data: String, hora: String): Date? {
    val formato = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    return formato.parse("$data $hora")
}

fun formatarData(data: Date): String {
    val formato = SimpleDateFormat("EEE, dd", Locale("pt", "BR"))
    return formato.format(data)
}

fun formatarHora(data: Date): String {
    val formato = SimpleDateFormat("HH:mm", Locale("pt", "BR"))
    return formato.format(data)
}
