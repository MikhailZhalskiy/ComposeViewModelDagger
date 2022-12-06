package com.mw.example.composeviewmodeldagger.di

import com.mw.example.composeviewmodeldagger.common.di.ViewModelAssistedFactoryKey
import com.mw.example.composeviewmodeldagger.common.di.ViewModelFactoryModule
import com.mw.example.composeviewmodeldagger.common.ViewModelAssistedFactory
import com.mw.example.composeviewmodeldagger.ui.screen.DetailEmailViewModel
import com.mw.example.composeviewmodeldagger.ui.screen.EmailListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [ViewModelFactoryModule::class]
)
interface AppViewModelModule {

    @Binds
    @[IntoMap ViewModelAssistedFactoryKey(EmailListViewModel::class)]
    fun bindsEmailListViewModelFactory(factory: EmailListViewModel.Factory): ViewModelAssistedFactory<*>

    @Binds
    @[IntoMap ViewModelAssistedFactoryKey(DetailEmailViewModel::class)]
    fun bindsDetailEmailViewModelFactory(factory: DetailEmailViewModel.Factory): ViewModelAssistedFactory<*>
}