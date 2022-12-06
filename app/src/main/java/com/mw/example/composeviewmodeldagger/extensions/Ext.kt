package com.mw.example.composeviewmodeldagger.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
public fun Inject(
    viewModelFactory: ViewModelFactory,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalViewModelFactory provides viewModelFactory,
        content = content
    )
}

@Composable
inline fun <reified VM : ViewModel> daggerViewModel(): VM {
    val factory = getViewModelFactory()
    return viewModel {
        val savedStateHandle = createSavedStateHandle()
        factory.create(VM::class.java, savedStateHandle)
    }
}

@Composable
@PublishedApi
internal fun getViewModelFactory(): ViewModelFactory {
    return checkNotNull(LocalViewModelFactory.current) {
        "No ViewModelFactory was provided via LocalViewModelFactory"
    }
}

public object LocalViewModelFactory {
    private val LocalViewModelFactory =
        compositionLocalOf<ViewModelFactory?> { null }

    public val current: ViewModelFactory?
        @Composable
        get() = LocalViewModelFactory.current

    public infix fun provides(viewModelFactory: ViewModelFactory):
            ProvidedValue<ViewModelFactory?> {
        return LocalViewModelFactory.provides(viewModelFactory)
    }
}