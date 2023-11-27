package com.paawk4.domain.models


import com.google.gson.annotations.SerializedName

data class Room(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("price_per")
    val pricePer: String,
    @SerializedName("peculiarities")
    val peculiarities: List<String>,
    @SerializedName("image_urls")
    val imageUrls: List<String>
)