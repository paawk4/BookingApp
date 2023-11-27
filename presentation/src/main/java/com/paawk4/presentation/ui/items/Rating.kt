package com.paawk4.presentation.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.paawk4.presentation.ui.theme.StarBgColor
import com.paawk4.presentation.ui.theme.StarColor

@Composable
fun Rating(rating: String) {
    Row(
        modifier = Modifier
            .background(StarBgColor, RoundedCornerShape(5.dp))
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = StarColor
        )
        Text(text = rating, color = StarColor, fontWeight = FontWeight.SemiBold)
    }
}