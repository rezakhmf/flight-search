package com.reza.skyscannertest.utils.extensions

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.text.SimpleDateFormat


fun View.isVisible() = this.visibility == View.VISIBLE

fun View.visible() { this.visibility = View.VISIBLE }

fun View.invisible() { this.visibility = View.GONE }

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)
fun String.UTCTime() : String {
    val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(this)
    val time = SimpleDateFormat("H:mm").format(date)
    return time
}



