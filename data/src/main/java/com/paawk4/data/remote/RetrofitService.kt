package com.paawk4.data.remote

import com.paawk4.domain.Result
import com.paawk4.domain.models.Booking
import com.paawk4.domain.models.Hotel
import com.paawk4.domain.models.Rooms
import retrofit2.Call

class RetrofitService {
    private val api = RetrofitInstance.create()

    fun getHotelData(): Result<Hotel> {
        val callResponse = api.getHotelData()
        return executeResponse(callResponse) as Result<Hotel>
    }

    fun getRoomsData(): Result<Rooms> {
        val callResponse = api.getRoomsData()
        return executeResponse(callResponse) as Result<Rooms>
    }

    fun getBookingData(): Result<Booking> {
        val callResponse = api.getBookingData()
        return executeResponse(callResponse) as Result<Booking>
    }

    private fun executeResponse(callResponse: Call<out Any>): Result<Any> {
        try {
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.let {
                    return Result.Success(it)
                }
            }
            return Result.Failure(Exception(response.message()))
        } catch (_: Exception) {
            return Result.Failure(Exception("no internet connection"))
        }
    }

}