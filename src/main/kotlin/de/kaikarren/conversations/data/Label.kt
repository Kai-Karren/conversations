package de.kaikarren.conversations.data

import com.google.gson.annotations.SerializedName

data class Label(
    val name: String = "",
    val confidence: Double = 1.0,

    @SerializedName("assigned_by")
    val assignedBy: String = ""
)
