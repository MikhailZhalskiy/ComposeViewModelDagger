package com.mw.example.composeviewmodeldagger.ui.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mw.example.composeviewmodeldagger.common.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EmailListViewModel @AssistedInject constructor(
    @Assisted private val handle: SavedStateHandle
) : ViewModel() {

    @AssistedFactory
    interface Factory : ViewModelAssistedFactory<EmailListViewModel>

    private val listIds = MutableStateFlow(createListId())
    fun getListId(): StateFlow<List<String>> = listIds

    private fun createListId(): List<String> {
        return buildList {
            repeat(20) {
                add("$it")
            }
        }
    }
}