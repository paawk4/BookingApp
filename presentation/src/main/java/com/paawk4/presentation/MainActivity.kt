package com.paawk4.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.paawk4.presentation.nav.AppNavHost
import com.paawk4.presentation.ui.theme.AppBgColor
import com.paawk4.presentation.ui.theme.HotelBookingTestTheme
import com.paawk4.presentation.ui.topbar.AppTopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HotelBookingTestTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color.White
                ) {
                    val navController = rememberNavController()
                    val (title, setTitle) = remember {
                        mutableStateOf("asd")
                    }
                    var isBackBtnEnabled by remember {
                        mutableStateOf(false)
                    }
                    Scaffold(
                        topBar = {
                            AppTopBar(
                                title = title,
                                isBackButtonEnabled = isBackBtnEnabled,
                                goBack = { navController.popBackStack() })
                        }
                    ) { paddingValues ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(AppBgColor)
                                .padding(paddingValues)
                        ) {
                            AppNavHost(
                                navController = navController,
                                setTitle = setTitle,
                                enableBackBtn = { isBackBtnEnabled = it })
                        }
                    }
                }
            }
        }
    }
}
