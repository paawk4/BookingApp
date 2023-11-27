package com.paawk4.data.remote

import com.paawk4.domain.models.Booking
import com.paawk4.domain.models.Hotel
import com.paawk4.domain.models.Rooms
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {


    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    fun getHotelData(): Call<Hotel>

    @GET("8b532701-709e-4194-a41c-1a903af00195")
    fun getRoomsData(): Call<Rooms>

    @GET("63866c74-d593-432c-af8e-f279d1a8d2ff")
    fun getBookingData(): Call<Booking>
}