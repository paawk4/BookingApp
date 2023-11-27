package com.paawk4.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.paawk4.presentation.ui.items.AboutHotelInfoBlock
import com.paawk4.presentation.ui.items.MainInfoHotelBlock
import com.paawk4.presentation.viewmodels.HotelViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HotelScreen(
    viewModel: HotelViewModel = koinViewModel(),
    goToRoomScreen: (String) -> Unit
) {
    val hotelData = viewModel.hotelData.observeAsState().value
    if (hotelData != null) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item {
                MainInfoHotelBlock(
                    "${hotelData.rating} ${hotelData.ratingName}",
                    hotelData.name,
                    hotelData.adress,
                    hotelData.minimalPrice,
                    hotelData.priceForIt,
                    hotelData.imageUrls
                )
            }
            item {
                AboutHotelInfoBlock(hotelData.aboutTheHotel)
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { goToRoomScreen(hotelData.name) },
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(
                            text = "К выбору номера",
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(vertical = 5.dp)
                        )
                    }
                }
            }
        }
    }
}





