package com.paawk4.presentation.nav

sealed class Screen(val route: String, val title: String) {
    data object Hotel : Screen("hotel", "Отель")
    data object Room : Screen("room", "")
    data object Booking : Screen("booking", "Бронирование")
    data object Paid : Screen("paid", "Заказ оплачен")
}