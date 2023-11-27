package com.paawk4.domain.models


import com.google.gson.annotations.SerializedName
import com.paawk4.domain.models.Room

data class Rooms(
    @SerializedName("rooms")
    val rooms: List<Room>
)