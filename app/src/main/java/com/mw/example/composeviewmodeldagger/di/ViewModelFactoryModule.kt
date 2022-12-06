package com.mw.example.composeviewmodeldagger.di

import com.mw.example.composeviewmodeldagger.extensions.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindsFactoryViewModelAssistedFactory(factory: DaggerViewModelAssistedFactory): ViewModelFactory
}