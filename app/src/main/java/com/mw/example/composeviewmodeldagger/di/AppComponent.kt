package com.mw.example.composeviewmodeldagger.di

import com.mw.example.composeviewmodeldagger.extensions.ViewModelFactory
import dagger.Component

@Component(
    modules = [ViewModelModule::class]
)
interface AppComponent {
    fun getFactoryViewModelAssistedFactory(): ViewModelFactory
}