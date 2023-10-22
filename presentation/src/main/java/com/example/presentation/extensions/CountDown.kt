package com.example.presentation.extensions

import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import java.text.DecimalFormat
import java.text.NumberFormat

fun Fragment.countDown(
    totalSeconds: Long = 31000,
    timeForTick: Long = 1000,
    onFinish: () -> Unit = {},
    onMyTick: (currentSecond: Int) -> Unit
) {
    var timer: CountDownTimer? = null
    timer = object : CountDownTimer(totalSeconds, timeForTick) {
        override fun onTick(millisUntilFinished: Long) {
            val f: NumberFormat = DecimalFormat("00")
            val sec = millisUntilFinished / 1000 % 60
            onMyTick(f.format(sec).toInt())
        }

        override fun onFinish() {
            timer?.cancel()
            onFinish()
        }
    }
    timer.start()
}