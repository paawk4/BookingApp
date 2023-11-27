package com.paawk4.presentation.ui.items

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paawk4.presentation.ui.theme.AccentColor

@Composable
fun MainHotelInfoBlock(rating: String, name: String, address: String) {
    Rating(rating)
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = name,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = address,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = AccentColor,
    )
}