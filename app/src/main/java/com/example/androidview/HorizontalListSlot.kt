package com.example.androidview

import android.util.Log
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun HorizontalListSlot(
    item: HorizontalListItem,
    modifier: Modifier = Modifier,
) {
    Column(modifier.padding(16.dp)) {
        Text(
            text = item.title,
            style = TextStyle.Default.copy(fontSize = 16.sp),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow {
            items(
                items = item.articles.value,
                key = { it.id },
                contentType = { it::class.simpleName },
            ) { article ->
                when (article) {
                    is HorizontalComposeItem -> HorizontalComposeSlot(article)
                    is HorizontalAndroidViewItem -> HorizontalAndroidViewSlot(article)
                }
            }
        }
    }
}

@Composable
private fun HorizontalComposeSlot(
    item: HorizontalComposeItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .size(width = 140.dp, height = 160.dp)
            .padding(horizontal = 5.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
                .background(Color.Green),
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 3.dp),
            text = item.title,
            style = TextStyle.Default.copy(fontSize = 12.sp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 3.dp),
            text = item.description,
            style = TextStyle.Default.copy(fontSize = 13.sp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun HorizontalAndroidViewSlot(
    item: HorizontalAndroidViewItem,
    modifier: Modifier = Modifier,
) {
    AndroidView(
        modifier = modifier
            .size(width = 140.dp, height = 160.dp)
            .background(Color.LightGray)
            .padding(horizontal = 5.dp),
        factory = ::TextView,
        update = { it.text = item.title },
        onReset = { it.text = null },
        onRelease = { Log.e("GLEN", "[${item.title}] onRelease") }
    )
}
