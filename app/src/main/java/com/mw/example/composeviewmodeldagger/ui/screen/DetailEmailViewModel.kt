package com.mw.example.composeviewmodeldagger.ui.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mw.example.composeviewmodeldagger.common.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class DetailEmailViewModel @AssistedInject constructor(
    @Assisted private val handle: SavedStateHandle
) : ViewModel() {

    @AssistedFactory
    interface Factory : ViewModelAssistedFactory<DetailEmailViewModel>

    fun getArg(): Screen.EmailDetail.Arg = Screen.EmailDetail.getArg(handle)
}