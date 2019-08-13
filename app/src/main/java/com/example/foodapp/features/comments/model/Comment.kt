package com.example.foodapp.features.comments.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comment(val comment: String, val name: String, val avatar: String) : Parcelable
