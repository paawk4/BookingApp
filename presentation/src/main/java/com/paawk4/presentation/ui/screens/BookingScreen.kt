package com.paawk4.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.paawk4.presentation.viewmodels.BookingViewModel
import com.paawk4.presentation.ui.items.BookingInfoBlock
import com.paawk4.presentation.ui.items.BuyerInfoBlock
import com.paawk4.presentation.ui.items.FinalPriceBlock
import com.paawk4.presentation.ui.items.MainHotelInfoBlock
import com.paawk4.presentation.ui.items.TouristBlock
import org.koin.androidx.compose.koinViewModel

@Composable
fun BookingScreen(
    viewModel: BookingViewModel = koinViewModel(),
    goToPaidScreen: () -> Unit,
) {
    val bookingData = viewModel.bookingData.observeAsState().value
    bookingData?.let {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, RoundedCornerShape(15.dp))
                        .padding(16.dp)
                ) {
                    MainHotelInfoBlock(
                        "${it.horating} ${it.ratingName}",
                        it.hotelName,
                        it.hotelAdress
                    )
                }
            }
            item {
                BookingInfoBlock(it)
            }
            item {
                BuyerInfoBlock(viewModel)
            }
            item {
                TouristBlock(viewModel)
            }
            item {
                FinalPriceBlock(it)
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
                        onClick = { viewModel.onPayBtnPressed { goToPaidScreen() } },
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(
                            text = "Оплатить ${bookingData.tourPrice} ₽",
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(vertical = 5.dp)
                        )
                    }
                }
            }
        }
    }
}
