package com.paawk4.bookingapp

import com.paawk4.data.remote.RetrofitService
import com.paawk4.data.repos.BookingRepositoryImpl
import com.paawk4.data.repos.HotelRepositoryImpl
import com.paawk4.data.repos.RoomsRepositoryImpl
import com.paawk4.domain.repos.BookingRepository
import com.paawk4.domain.repos.HotelRepository
import com.paawk4.domain.repos.RoomsRepository
import com.paawk4.domain.usecases.GetBookingDataUseCase
import com.paawk4.domain.usecases.GetHotelDataUseCase
import com.paawk4.domain.usecases.GetRoomsDataUseCase
import com.paawk4.presentation.viewmodels.BookingViewModel
import com.paawk4.presentation.viewmodels.HotelViewModel
import com.paawk4.presentation.viewmodels.RoomsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoriesModule = module {
    single { RetrofitService() }
    single<HotelRepository> { HotelRepositoryImpl(get()) }
    single<RoomsRepository> { RoomsRepositoryImpl(get()) }
    single<BookingRepository> { BookingRepositoryImpl(get()) }
}

val viewModelsModule = module {
    viewModel { HotelViewModel(get()) }
    viewModel { RoomsViewModel(get()) }
    viewModel { BookingViewModel(get()) }
}

val useCasesModule = module {
    single { GetHotelDataUseCase() }
    single { GetRoomsDataUseCase() }
    single { GetBookingDataUseCase() }
}