package com.mw.example.composeviewmodeldagger.common.di

import com.mw.example.composeviewmodeldagger.common.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindsFactoryViewModelAssistedFactory(factory: DaggerViewModelAssistedFactory): ViewModelFactory
}