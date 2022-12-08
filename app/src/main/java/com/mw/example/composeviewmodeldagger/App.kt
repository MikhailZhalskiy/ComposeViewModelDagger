package com.mw.example.composeviewmodeldagger

import android.app.Application
import com.mw.example.composeviewmodeldagger.di.AppComponent
import com.mw.example.composeviewmodeldagger.di.DaggerAppComponent
import com.mw.example.composeviewmodeldagger.di.DaggerOtherComponent
import com.mw.example.composeviewmodeldagger.di.OtherComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        otherComponent = DaggerOtherComponent.create()
    }

    companion object {
        private lateinit var appComponent: AppComponent
        val app: AppComponent get() = appComponent

        private lateinit var otherComponent: OtherComponent
        val other: OtherComponent get() = otherComponent
    }
}