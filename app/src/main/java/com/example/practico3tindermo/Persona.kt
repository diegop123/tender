package com.example.practico3tindermo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Persona(val name: String, val imageResources: List<Int>) : Parcelable
