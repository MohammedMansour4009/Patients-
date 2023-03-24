package com.training.tasktwo.core.extension

import androidx.appcompat.widget.AppCompatTextView

fun String.addPoint(): String {
    return "$this."
}

fun AppCompatTextView.addPoint() {
    this.text = text.toString().addPoint()
}