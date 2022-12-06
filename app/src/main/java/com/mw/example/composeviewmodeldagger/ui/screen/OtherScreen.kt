package com.mw.example.composeviewmodeldagger.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mw.example.composeviewmodeldagger.common.daggerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtherScreen(
    viewModel: OtherViewModel = daggerViewModel(),
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "OtherScreen") }
        )
        Text(
            text = "Screen.OtherScreen.getArg(handle) = ${viewModel.getArg().other}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}