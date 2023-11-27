package com.paawk4.bookingapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BookingApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BookingApplication)
            modules(listOf(repositoriesModule, viewModelsModule, useCasesModule))
        }
    }
}