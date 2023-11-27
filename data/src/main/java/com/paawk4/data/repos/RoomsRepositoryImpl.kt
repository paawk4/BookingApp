package com.paawk4.data.repos

import com.paawk4.data.remote.RetrofitService
import com.paawk4.domain.Result
import com.paawk4.domain.models.Rooms
import com.paawk4.domain.repos.RoomsRepository

class RoomsRepositoryImpl(
    private val retrofitService: RetrofitService
) : RoomsRepository {
    override fun getRoomsData(): Result<Rooms> {
        return retrofitService.getRoomsData()
    }
}