package com.paawk4.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paawk4.domain.models.Hotel
import com.paawk4.domain.usecases.GetHotelDataUseCase
import com.paawk4.hotelbookingtest.presentation.viewmodels.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HotelViewModel(
    private val getHotelDataUseCase: GetHotelDataUseCase
) : BaseViewModel() {

    private val _hotelData: MutableLiveData<Hotel> = MutableLiveData()
    val hotelData: LiveData<Hotel>
        get() {
            return _hotelData
        }

    init {
        requestHotelData()
    }

    private fun requestHotelData() = launch {
        when (val result = withContext(Dispatchers.IO) { getHotelDataUseCase() }) {
            is com.paawk4.domain.Result.Success -> {
                _hotelData.value = result.data
            }

            is com.paawk4.domain.Result.Failure -> {

            }
        }
    }
}