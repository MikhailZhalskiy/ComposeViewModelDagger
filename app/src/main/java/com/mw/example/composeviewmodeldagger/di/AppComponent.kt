package com.mw.example.composeviewmodeldagger.di

import com.mw.example.composeviewmodeldagger.common.ViewModelFactory
import dagger.Component

@Component(
    modules = [AppViewModelModule::class]
)
interface AppComponent {
    fun getViewModelFactory(): ViewModelFactory
}