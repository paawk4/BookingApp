package com.paawk4.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paawk4.presentation.ui.theme.GrayColor
import com.paawk4.presentation.R
import kotlin.random.Random

@Composable
fun PaidScreen(goBackHotelScreen: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.paid_success),
                contentDescription = null,
                modifier = Modifier.height(100.dp),
                contentScale = ContentScale.FillHeight
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Ваш заказ принят в работу",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            val randomOrderNumber = Random.nextInt(100000, 999999)
            Text(
                text = "Подтверждение заказа №$randomOrderNumber может занять некоторое время (от 1 часа до суток). Как только мы получим ответ от туроператора, вам на почту придет уведомление.",
                color = GrayColor
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            onClick = { goBackHotelScreen() },
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = "Супер!",
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
    }
}