package com.paawk4.data.repos

import com.paawk4.data.remote.RetrofitService
import com.paawk4.domain.Result
import com.paawk4.domain.models.Hotel
import com.paawk4.domain.repos.HotelRepository

class HotelRepositoryImpl(
    private val retrofitService: RetrofitService
) : HotelRepository {
    override fun getHotelData(): Result<Hotel> {
        return retrofitService.getHotelData()
    }
}