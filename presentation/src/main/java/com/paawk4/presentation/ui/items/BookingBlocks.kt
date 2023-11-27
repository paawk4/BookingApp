package com.paawk4.presentation.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paawk4.domain.models.Booking
import com.paawk4.presentation.ui.theme.AccentColor
import com.paawk4.presentation.ui.theme.GrayColor
import com.paawk4.presentation.ui.utils.TextFieldTypes
import com.paawk4.presentation.viewmodels.BookingViewModel

@Composable
fun BuyerInfoBlock(viewModel: BookingViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(15.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Информация о покупателе",
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        AppTextField(
            text = viewModel.phoneNumber,
            "Номер телефона",
            type = TextFieldTypes.PHONE_TYPE,
            isError = viewModel.isPhoneNumberError
        ) {
            viewModel.updatePhoneNumber(it)
        }

        Spacer(modifier = Modifier.height(8.dp))

        AppTextField(
            text = viewModel.email,
            "Почта",
            type = TextFieldTypes.EMAIL_TYPE,
            isError = viewModel.isEmailError
        ) {
            viewModel.updateEmail(it)
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Эти данные никому не передаются. После оплаты мы вышли чек на указанный вами номер и почту",
            fontSize = 14.sp,
            color = GrayColor,
            lineHeight = 17.sp
        )
    }
}

@Composable
fun BookingInfoBlock(booking: Booking) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(15.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        val listOfBookingInfoItems = listOf(
            Pair("Вылет из", booking.departure),
            Pair("Страна, город", booking.arrivalCountry),
            Pair("Даты", "${booking.tourDateStart} - ${booking.tourDateStop}"),
            Pair("Кол-во ночей", "${booking.numberOfNights} ночей"),
            Pair("Отель", booking.hotelName),
            Pair("Номер", booking.room),
            Pair("Питание", booking.nutrition),
        )
        listOfBookingInfoItems.forEach {
            BookingInfoItem(it.first, it.second)
        }
    }
}

@Composable
fun TouristBlock(viewModel: BookingViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(15.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Первый турист",
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        AppTextField(
            text = viewModel.name,
            "Имя",
            type = TextFieldTypes.TEXT_TYPE,
            isError = viewModel.isNameError
        ) {
            viewModel.updateName(it)
        }

        Spacer(modifier = Modifier.height(8.dp))

        AppTextField(
            text = viewModel.surname,
            "Фамилия",
            type = TextFieldTypes.TEXT_TYPE,
            isError = viewModel.isSurnameError
        ) {
            viewModel.updateSurname(it)
        }

        Spacer(modifier = Modifier.height(8.dp))

        AppTextField(
            text = viewModel.birthDate,
            "Дата рождения",
            type = TextFieldTypes.TEXT_TYPE,
            isError = viewModel.isBirthDateError
        ) {
            viewModel.updateBirthDate(it)
        }

        Spacer(modifier = Modifier.height(8.dp))

        AppTextField(
            text = viewModel.citizenship,
            "Гражданство",
            type = TextFieldTypes.TEXT_TYPE,
            isError = viewModel.isCitizenshipError
        ) {
            viewModel.updateCitizenship(it)
        }

        Spacer(modifier = Modifier.height(8.dp))

        AppTextField(
            text = viewModel.passportNumber,
            "Номер загранпаспорта",
            type = TextFieldTypes.TEXT_TYPE,
            isError = viewModel.isPassportNumberError
        ) {
            viewModel.updatePassportNumber(it)
        }

        Spacer(modifier = Modifier.height(8.dp))

        AppTextField(
            text = viewModel.passportValidity,
            "Срок действия загранпаспорта",
            type = TextFieldTypes.NUMBER_TYPE,
            isError = viewModel.isPassportValidityError
        ) {
            viewModel.updatePassportValidity(it)
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun FinalPriceBlock(booking: Booking) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(15.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Тур", color = GrayColor)
            Text(text = "${booking.tourPrice} ₽")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Топливный сбор", color = GrayColor)
            Text(text = "${booking.fuelCharge} ₽")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Сервисный сбор", color = GrayColor)
            Text(text = "${booking.serviceCharge} ₽")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "К оплате", color = GrayColor)
            Text(text = "${booking.tourPrice} ₽", color = AccentColor)
        }
    }
}

@Composable
fun BookingInfoItem(label: String, data: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = label,
            color = GrayColor,
            modifier = Modifier.width(140.dp)
        )
        Text(text = data, lineHeight = 19.sp)
    }
}
