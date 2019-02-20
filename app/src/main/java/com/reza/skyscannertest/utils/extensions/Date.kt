package com.reza.skyscannertest.utils.extensions

import java.util.*

fun Date.Diff(from: Date?) : Long {
    val duration = Math.abs(this.time.minus(from?.time!!))
    return duration
}