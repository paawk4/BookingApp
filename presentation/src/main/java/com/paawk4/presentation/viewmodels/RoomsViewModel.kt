package com.paawk4.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paawk4.domain.models.Rooms
import com.paawk4.domain.usecases.GetRoomsDataUseCase
import com.paawk4.hotelbookingtest.presentation.viewmodels.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomsViewModel(
    private val getRoomsDataUseCase: GetRoomsDataUseCase
) : BaseViewModel() {

    private val _roomsData: MutableLiveData<Rooms> = MutableLiveData()
    val roomsData: LiveData<Rooms>
        get() {
            return _roomsData
        }

    init {
        requestRoomsData()
    }

    private fun requestRoomsData() = launch {
        when (val result = withContext(Dispatchers.IO) { getRoomsDataUseCase() }) {
            is com.paawk4.domain.Result.Success -> {
                _roomsData.value = result.data
            }

            is com.paawk4.domain.Result.Failure -> {

            }
        }
    }

}