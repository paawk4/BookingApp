package com.paawk4.domain.repos

import com.paawk4.domain.Result
import com.paawk4.domain.models.Hotel

interface HotelRepository {

    fun getHotelData(): Result<Hotel>
}