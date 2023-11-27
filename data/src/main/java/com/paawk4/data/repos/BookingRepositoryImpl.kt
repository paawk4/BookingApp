package com.paawk4.data.repos

import com.paawk4.domain.Result
import com.paawk4.data.remote.RetrofitService
import com.paawk4.domain.models.Booking
import com.paawk4.domain.repos.BookingRepository

class BookingRepositoryImpl(
    private val retrofitService: RetrofitService
) : BookingRepository {
    override fun getBookingData(): Result<Booking> {
        return retrofitService.getBookingData()
    }

}