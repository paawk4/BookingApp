package com.paawk4.presentation.ui.items

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paawk4.domain.models.AboutTheHotel
import com.paawk4.presentation.ui.theme.GrayBgColor
import com.paawk4.presentation.ui.theme.GrayColor
import com.paawk4.presentation.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AboutHotelInfoBlock(aboutTheHotel: AboutTheHotel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.White,
                RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = "Об отеле",
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        FlowRow(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            aboutTheHotel.peculiarities.forEach {
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
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = aboutTheHotel.description,
            lineHeight = 19.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(GrayBgColor, RoundedCornerShape(15.dp))
        ) {
            val listOfAdditionalInfoButtons = listOf(
                AdditionalInfoButton(
                    "Удобства",
                    "Самое необходимое",
                    painterResource(id = R.drawable.ic_happy)
                ),
                AdditionalInfoButton(
                    "Что включено",
                    "Самое необходимое",
                    painterResource(id = R.drawable.ic_enable)
                ),
                AdditionalInfoButton(
                    "Что не включено",
                    "Самое необходимое",
                    painterResource(id = R.drawable.ic_disable)
                )
            )
            listOfAdditionalInfoButtons.forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {}
                        .padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(painter = it.icon, contentDescription = null)
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(text = it.title, fontWeight = FontWeight.Medium)
                            Text(
                                text = it.desc,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = GrayColor
                            )
                        }
                    }

                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
                }
            }
        }
    }
}

data class AdditionalInfoButton(
    val title: String,
    val desc: String,
    val icon: Painter
)

@Composable
fun MainInfoHotelBlock(
    rating: String,
    name: String,
    address: String,
    minimalPrice: Int,
    priceForIt: String,
    imageUrls: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.White,
                RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp)
            )
            .padding(horizontal = 16.dp)
    ) {
        HorizontalImagePager(imageUrls)
        Spacer(modifier = Modifier.height(16.dp))
        MainHotelInfoBlock(rating, name, address)
        Spacer(modifier = Modifier.height(16.dp))
        Cost(minimalPrice, priceForIt)
        Spacer(modifier = Modifier.height(16.dp))
    }
}