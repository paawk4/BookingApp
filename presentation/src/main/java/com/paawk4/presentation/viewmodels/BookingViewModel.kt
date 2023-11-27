package com.paawk4.presentation.viewmodels

import android.text.TextUtils
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paawk4.domain.models.Booking
import com.paawk4.domain.usecases.GetBookingDataUseCase
import com.paawk4.hotelbookingtest.presentation.viewmodels.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookingViewModel(
    private val getBookingDataUseCase: GetBookingDataUseCase
) : BaseViewModel() {

    var phoneNumber by mutableStateOf("")
        private set
    var isPhoneNumberError by mutableStateOf(false)
        private set

    fun updatePhoneNumber(input: String) {
        phoneNumber = input
        resetPhoneNumberError()
    }

    private fun resetPhoneNumberError() {
        isPhoneNumberError = false
    }

    var email by mutableStateOf("")
        private set
    var isEmailError by mutableStateOf(false)
        private set

    fun updateEmail(input: String) {
        email = input
        resetEmailError()
        if (!input.isEmailValid()) {
            isEmailError = true
        }
    }

    private fun resetEmailError() {
        isEmailError = false
    }

    var name by mutableStateOf("")
        private set
    var isNameError by mutableStateOf(false)
        private set

    fun updateName(input: String) {
        name = input
        resetNameError()
    }

    private fun resetNameError() {
        isNameError = false
    }

    var surname by mutableStateOf("")
        private set
    var isSurnameError by mutableStateOf(false)
        private set

    fun updateSurname(input: String) {
        surname = input
        resetSurnameError()
    }

    private fun resetSurnameError() {
        isSurnameError = false
    }

    var birthDate by mutableStateOf("")
        private set
    var isBirthDateError by mutableStateOf(false)
        private set

    fun updateBirthDate(input: String) {
        birthDate = input
        resetBirthDateError()
    }

    private fun resetBirthDateError() {
        isBirthDateError = false
    }

    var citizenship by mutableStateOf("")
        private set
    var isCitizenshipError by mutableStateOf(false)
        private set

    fun updateCitizenship(input: String) {
        citizenship = input
        resetCitizenshipError()
    }

    private fun resetCitizenshipError() {
        isCitizenshipError = false
    }

    var passportNumber by mutableStateOf("")
        private set
    var isPassportNumberError by mutableStateOf(false)
        private set

    fun updatePassportNumber(input: String) {
        passportNumber = input
        resetPassportNumberError()
    }

    private fun resetPassportNumberError() {
        isPassportNumberError = false
    }

    var passportValidity by mutableStateOf("")
        private set
    var isPassportValidityError by mutableStateOf(false)
        private set

    fun updatePassportValidity(input: String) {
        passportValidity = input
        resetPassportValidityError()
    }

    private fun resetPassportValidityError() {
        isPassportValidityError = false
    }


    private val _bookingData: MutableLiveData<Booking> = MutableLiveData()
    val bookingData: LiveData<Booking>
        get() {
            return _bookingData
        }

    init {
        requestBookingData()
    }

    private fun requestBookingData() = launch {
        when (val result = withContext(Dispatchers.IO) { getBookingDataUseCase() }) {
            is com.paawk4.domain.Result.Success -> {
                _bookingData.value = result.data
            }

            is com.paawk4.domain.Result.Failure -> {

            }
        }
    }

    fun onPayBtnPressed(onSuccess: () -> Unit) {
        if (validateInput()) {
            onSuccess()
        }
    }

    private fun validateInput(): Boolean {
        var result = true
        if (phoneNumber.trim().isBlank() || phoneNumber.trim().length < 10) {
            isPhoneNumberError = true
            result = false
        }
        if (email.trim().isBlank()) {
            isEmailError = true
            result = false
        }
        if (name.trim().isBlank()) {
            isNameError = true
            result = false
        }
        if (surname.trim().isBlank()) {
            isSurnameError = true
            result = false
        }
        if (birthDate.trim().isBlank()) {
            isBirthDateError = true
            result = false
        }
        if (citizenship.trim().isBlank()) {
            isCitizenshipError = true
            result = false
        }
        if (passportNumber.trim().isBlank()) {
            isPassportNumberError = true
            result = false
        }
        if (passportValidity.trim().isBlank()) {
            isPassportValidityError = true
            result = false
        }
        return result
    }
}

fun String.isEmailValid(): Boolean {
    return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}