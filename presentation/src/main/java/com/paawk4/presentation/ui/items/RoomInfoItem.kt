package com.paawk4.presentation.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paawk4.domain.models.Room
import com.paawk4.presentation.ui.theme.AccentBgColor
import com.paawk4.presentation.ui.theme.AccentColor
import com.paawk4.presentation.ui.theme.GrayBgColor
import com.paawk4.presentation.ui.theme.GrayColor

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RoomInfoItem(room: Room, goToBookingScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        HorizontalImagePager(room.imageUrls)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = room.name,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            room.peculiarities.forEach {
                Text(
                    text = it,
                    fontWeight = FontWeight.Medium,
                    color = GrayColor,
                    modifier = Modifier
                        .background(GrayBgColor, RoundedCornerShape(5.dp))
                        .padding(vertical = 5.dp, horizontal = 10.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .background(AccentBgColor, RoundedCornerShape(5.dp))
                .padding(start = 10.dp)
                .clickable { },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Подробнее о номере",
                fontWeight = FontWeight.Medium,
                color = AccentColor,
                modifier = Modifier.padding(vertical = 5.dp)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = AccentColor
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Cost(room.price, room.pricePer)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { goToBookingScreen() },
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(
                text = "Выбрать номер",
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
    }
}