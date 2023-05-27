package com.ifkusyoba.submissionandroidsederhadana

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Music(
    val name: String,
    val description: String,
    val photo: Int,
    val history: String,
) : Parcelable
