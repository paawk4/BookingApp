package com.paawk4.domain.repos

import com.paawk4.domain.Result
import com.paawk4.domain.models.Rooms

interface RoomsRepository {

    fun getRoomsData(): Result<Rooms>
}