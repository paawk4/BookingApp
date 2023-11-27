package com.paawk4.domain.repos

import com.paawk4.domain.Result
import com.paawk4.domain.models.Booking

interface BookingRepository {

    fun getBookingData(): Result<Booking>
}