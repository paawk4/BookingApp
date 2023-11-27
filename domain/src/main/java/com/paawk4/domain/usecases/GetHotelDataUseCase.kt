package com.paawk4.domain.usecases

import com.paawk4.domain.repos.HotelRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetHotelDataUseCase : KoinComponent {
    private val repository: HotelRepository by inject()
    operator fun invoke() = repository.getHotelData()
}