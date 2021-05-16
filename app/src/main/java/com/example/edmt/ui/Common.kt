package com.example.edmt.ui

import android.widget.TextView
import java.util.*

object Common {
    fun setWelcomeMessage(txtWelcome: TextView) {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        if (hour >= 1 && hour <= 12)
            txtWelcome.setText(java.lang.StringBuilder("Good morning."))
        else
            if (hour > 12 && hour <= 17)
                txtWelcome.setText(java.lang.StringBuilder("Good afternoon."))
        else
                txtWelcome.setText(java.lang.StringBuilder("Good evening."))
    }

}