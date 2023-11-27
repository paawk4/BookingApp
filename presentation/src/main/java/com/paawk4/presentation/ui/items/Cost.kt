package com.paawk4.presentation.ui.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paawk4.presentation.ui.theme.GrayColor

@Composable
fun Cost(minimalPrice: Int, priceForIt: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "от $minimalPrice ₽", fontWeight = FontWeight.SemiBold, fontSize = 30.sp)
        Text(text = priceForIt, color = GrayColor)
    }
}