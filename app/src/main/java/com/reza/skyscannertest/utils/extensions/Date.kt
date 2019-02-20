package com.reza.skyscannertest.utils.extensions

import java.util.*
import java.util.concurrent.TimeUnit

fun Date.Diff(from: Date?) : Long {
    val duration = Math.abs(this.time.minus(from?.time!!))
    return TimeUnit.HOURS.convert(duration, TimeUnit.MILLISECONDS)
}