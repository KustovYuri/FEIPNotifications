package com.example.feipnotifications.presentation.notifications

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.feipnotifications.R
import com.example.feipnotifications.util.LoadingContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Notifications(
    modifier: Modifier = Modifier,
    viewModel: NotificationsViewModel = viewModel(),
) {
    Scaffold(
        topBar = {

        },
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Filled.Add, stringResource(id = R.string.add_task))
            }
        }
    ) {  paddingValues ->
        NotificationsContent(
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
private fun NotificationsContent(
    modifier: Modifier = Modifier,
){
    LoadingContent(
        loading = false,
        empty = false,
        emptyContent = {  },
        onRefresh = {}
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = dimensionResource(id = R.dimen.horizontal_margin))
        ) {
            items(45) {
                NotificationItem(
                    itemId = it,
                    onTaskClick = {},
                )
            }
        }
    }
}

@Composable
private fun NotificationItem(
    itemId:Int,
    onTaskClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = R.dimen.horizontal_margin),
                vertical = dimensionResource(id = R.dimen.list_item_padding),
            )
            .clickable { onTaskClick() }
    ) {
        Text(
            text = "Напоминание ${itemId+1}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(
                start = dimensionResource(id = R.dimen.horizontal_margin)
            ),
        )
    }
}