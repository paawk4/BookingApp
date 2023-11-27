package com.paawk4.domain.usecases

import com.paawk4.domain.repos.BookingRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetBookingDataUseCase : KoinComponent {
    private val repository: BookingRepository by inject()
    operator fun invoke() = repository.getBookingData()
}