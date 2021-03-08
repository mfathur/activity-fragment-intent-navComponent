package com.mfathurz.activityfragmentintent.core.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * container => class yang bisa nampung
 */
@Parcelize
data class User(
    val id: Int,
    val name: String,
    val city: String
) : Parcelable



