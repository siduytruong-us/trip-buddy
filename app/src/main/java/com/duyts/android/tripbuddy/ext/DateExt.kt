package com.duyts.android.tripbuddy.ext

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.toLocalDate() = SimpleDateFormat("EEE, MM/dd", Locale.getDefault()).format(this)