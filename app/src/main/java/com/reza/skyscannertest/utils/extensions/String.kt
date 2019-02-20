package com.reza.skyscannertest.utils.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.UTCDateTime() : Date {
    val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(this)
    return date
}

fun String.NextMonday() : String {

    val now = Calendar.getInstance()
    val weekday = now.get(Calendar.DAY_OF_WEEK)
    if (weekday !== Calendar.MONDAY) {
        val days = (Calendar.SATURDAY - weekday + 2) % 7
        now.add(Calendar.DAY_OF_YEAR, days)
    }
    return SimpleDateFormat("yyyy-MM-dd").format(now.getTime())
}

fun String.NextTuesday() : String {

    val now = Calendar.getInstance()

    val weekday = now.get(Calendar.DAY_OF_WEEK)
    if (weekday !== Calendar.MONDAY) {
        val days = (Calendar.SATURDAY - weekday + 2) % 7
        now.add(Calendar.DAY_OF_YEAR, days)
    }

    now.add(Calendar.DAY_OF_YEAR, 1)

    return SimpleDateFormat("yyyy-MM-dd").format(now.getTime())
}

