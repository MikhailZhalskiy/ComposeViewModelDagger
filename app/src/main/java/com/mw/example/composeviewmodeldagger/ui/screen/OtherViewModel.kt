package com.mw.example.composeviewmodeldagger.ui.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mw.example.composeviewmodeldagger.common.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class OtherViewModel @AssistedInject constructor(
    @Assisted private val handle: SavedStateHandle
) : ViewModel() {

    @AssistedFactory
    interface Factory: ViewModelAssistedFactory<OtherViewModel>

    fun getArg(): Screen.Other.Arg = Screen.Other.getArg(handle)
}