package com.paawk4.presentation.nav

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.paawk4.presentation.ui.screens.BookingScreen
import com.paawk4.presentation.ui.screens.HotelScreen
import com.paawk4.presentation.ui.screens.PaidScreen
import com.paawk4.presentation.ui.screens.RoomScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    setTitle: (String) -> Unit,
    enableBackBtn: (Boolean) -> Unit
) {
    var roomsScreenTitle by remember {
        mutableStateOf("")
    }
    NavHost(
        navController = navController,
        startDestination = Screen.Hotel.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(Screen.Hotel.route) {
            HotelScreen {
                navController.navigate(Screen.Room.route)
                roomsScreenTitle = it
            }
            setTitle(Screen.Hotel.title)
            enableBackBtn(false)
        }
        composable(Screen.Room.route) {
            RoomScreen { navController.navigate(Screen.Booking.route) }
            setTitle(roomsScreenTitle)
            enableBackBtn(true)
        }
        composable(Screen.Booking.route) {
            BookingScreen { navController.navigate(Screen.Paid.route) }
            setTitle(Screen.Booking.title)
        }
        composable(Screen.Paid.route) {
            PaidScreen { navController.navigate(Screen.Hotel.route) }
            setTitle(Screen.Paid.title)
        }
    }
}