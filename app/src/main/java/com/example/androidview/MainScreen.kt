package com.example.androidview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    items: ImmutableList<VerticalItem>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(
            items = items.value,
            key = { it.id },
            contentType = { it::class.simpleName },
        ) { item ->
            when (item) {
                is BasicItem -> BasicSlot(item = item)
                is HorizontalListItem -> HorizontalListSlot(item = item)
            }
        }
    }
}
