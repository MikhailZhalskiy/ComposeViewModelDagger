package com.mw.example.composeviewmodeldagger.extensions

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface ViewModelAssistedFactory<T : ViewModel> {
    fun create(handle: SavedStateHandle): T
}