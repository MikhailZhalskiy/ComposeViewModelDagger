package com.mw.example.composeviewmodeldagger.di

import com.mw.example.composeviewmodeldagger.common.di.ViewModelAssistedFactoryKey
import com.mw.example.composeviewmodeldagger.common.di.ViewModelFactoryModule
import com.mw.example.composeviewmodeldagger.common.ViewModelAssistedFactory
import com.mw.example.composeviewmodeldagger.ui.screen.OtherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [ViewModelFactoryModule::class]
)
interface OtherViewModelModule {

    @Binds
    @[IntoMap ViewModelAssistedFactoryKey(OtherViewModel::class)]
    fun bindsOtherViewModelFactory(factory: OtherViewModel.Factory): ViewModelAssistedFactory<*>
}