package ru.netology.nmedia

import java.text.DecimalFormat
import kotlin.math.log10
import kotlin.math.pow

object FormatCounter {

    fun formatNumber(number: Int): String {
        if (number < 1000) {
            return number.toString()
        }
        val suffixes = arrayOf(" ", "K", "M")
        val formatter = DecimalFormat("#, ##0.#")
        val exp = (log10(number.toDouble()) / 3).toInt()
        return formatter.format(number / 10.0.pow(exp * 3)) + suffixes[exp]
    }
}