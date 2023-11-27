package com.paawk4.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paawk4.presentation.ui.items.RoomInfoItem
import com.paawk4.presentation.viewmodels.RoomsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun RoomScreen(
    viewModel: RoomsViewModel = koinViewModel(),
    goToBookingScreen: () -> Unit
) {
    val roomsData = viewModel.roomsData.observeAsState().value
    if (roomsData != null) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(roomsData.rooms) { room ->
                RoomInfoItem(
                    room,
                    goToBookingScreen
                )
            }
        }
    }
}

