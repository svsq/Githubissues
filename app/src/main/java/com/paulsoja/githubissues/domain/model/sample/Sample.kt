package com.paulsoja.githubissues.domain.model.sample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sample(
    val id: String,
    val name: String,
    val email: String
) : Parcelable