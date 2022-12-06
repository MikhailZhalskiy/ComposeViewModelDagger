package com.mw.example.composeviewmodeldagger.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mw.example.composeviewmodeldagger.extensions.daggerViewModel

@Composable
fun EmailListScreen(
    navigateEmailDetailScreen: (String) -> Unit,
    viewModel: EmailListViewModel = daggerViewModel(),
) {
    val itemList by viewModel.getListId().collectAsState()

    EmailListView(itemList, navigateEmailDetailScreen)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailListView(
    itemList: List<String>,
    navigateEmailDetailScreen: (String) -> Unit
) {
    Column {
        TopAppBar(
            title = { Text(text = "EmailListScreen") }
        )
        LazyColumn() {
            items(itemList) { item ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navigateEmailDetailScreen("Email $item") }
                        .padding(16.dp),
                    text = "Email $item"
                )
            }
        }
    }
}