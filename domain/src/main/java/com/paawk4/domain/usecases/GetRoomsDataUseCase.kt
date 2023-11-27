package com.paawk4.domain.usecases

import com.paawk4.domain.repos.RoomsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetRoomsDataUseCase : KoinComponent {
    private val repository: RoomsRepository by inject()
    operator fun invoke() = repository.getRoomsData()
}