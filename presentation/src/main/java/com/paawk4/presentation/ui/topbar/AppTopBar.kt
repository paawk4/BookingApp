package com.paawk4.presentation.ui.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppTopBar(title: String, isBackButtonEnabled: Boolean, goBack: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color.White)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Center).padding(vertical = 16.dp, horizontal = 30.dp),
            textAlign = TextAlign.Center,
            softWrap = true
        )
        if (isBackButtonEnabled) {
            IconButton(
                onClick = { goBack() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
            }
        }
    }
}