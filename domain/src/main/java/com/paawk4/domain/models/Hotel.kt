package com.paawk4.domain.models


import com.google.gson.annotations.SerializedName
import com.paawk4.domain.models.AboutTheHotel

data class Hotel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("adress")
    val adress: String,
    @SerializedName("minimal_price")
    val minimalPrice: Int,
    @SerializedName("price_for_it")
    val priceForIt: String,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("rating_name")
    val ratingName: String,
    @SerializedName("image_urls")
    val imageUrls: List<String>,
    @SerializedName("about_the_hotel")
    val aboutTheHotel: AboutTheHotel
)