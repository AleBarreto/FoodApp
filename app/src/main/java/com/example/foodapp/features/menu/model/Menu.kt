package com.example.foodapp.features.menu.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Menu(
    val id: Int, val name:
    String, val description: String, val price: Int, val thumbnail: String
) : Parcelable