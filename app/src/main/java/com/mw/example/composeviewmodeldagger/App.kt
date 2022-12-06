package com.mw.example.composeviewmodeldagger

import android.app.Application
import com.mw.example.composeviewmodeldagger.di.AppComponent
import com.mw.example.composeviewmodeldagger.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    companion object {
        private lateinit var appComponent: AppComponent
        val instance: AppComponent get() = appComponent
    }
}