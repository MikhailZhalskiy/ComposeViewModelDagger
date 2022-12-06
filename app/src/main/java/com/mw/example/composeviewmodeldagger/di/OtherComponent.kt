package com.mw.example.composeviewmodeldagger.di

import com.mw.example.composeviewmodeldagger.common.ViewModelFactory
import dagger.Component

@Component(
    modules = [OtherViewModelModule::class]
)
interface OtherComponent {
    fun getFactoryViewModelAssistedFactory(): ViewModelFactory
}