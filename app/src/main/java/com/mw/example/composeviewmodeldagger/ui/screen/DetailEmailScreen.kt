package com.mw.example.composeviewmodeldagger.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mw.example.composeviewmodeldagger.common.daggerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailEmailScreen(
    navigateOtherScreen: (String) -> Unit,
    viewModel: DetailEmailViewModel = daggerViewModel(),
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "DetailEmailScreen") }
        )
        Text(
            text = "Screen.EmailDetail.getArg(handle) = ${viewModel.getArg().email}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), onClick = { navigateOtherScreen("OtherInfo") }
        ) {
            Text(text = "Navigate to OtherScreen")
        }
    }
}