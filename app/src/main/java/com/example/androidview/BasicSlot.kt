package com.example.androidview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

@Composable
fun BasicSlot(
    item: BasicItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        BasicSlotHeader(item.publisher, item.date)
        Spacer(modifier = Modifier.height(3.dp))
        BasicSlotTextArticle(item.articles.value[0])
        Spacer(modifier = Modifier.height(3.dp))
        BasicSlotTextArticle(item.articles.value[1])
        Spacer(modifier = Modifier.height(3.dp))
        BasicSlotTextArticle(item.articles.value[2])
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            BasicSlotImageArticle(article = item.articles.value[3], modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(5.dp))
            BasicSlotImageArticle(article = item.articles.value[4], modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun BasicSlotHeader(
    publisher: String,
    date: String,
    modifier: Modifier = Modifier,
) {
    Row(modifier) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {
            Text(
                text = publisher,
                style = TextStyle.Default.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = date,
                style = TextStyle.Default.copy(fontSize = 12.sp)
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Button(
            modifier = modifier.wrapContentSize(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            contentPadding = PaddingValues(vertical = 12.dp, horizontal = 6.dp),
            shape = RoundedCornerShape(16.dp),
            onClick = { },
        ) {
            Text(
                modifier = Modifier.wrapContentSize(),
                text = "Subscribe",
                style = TextStyle.Default.copy(
                    color = Color.White,
                    fontSize = 16.sp,
                ),
            )
        }
    }
}

@Composable
private fun BasicSlotTextArticle(
    article: BasicItem.Article,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier.padding(vertical = 5.dp),
        text = article.title,
        style = TextStyle.Default.copy(fontSize = 14.sp),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun BasicSlotImageArticle(
    article: BasicItem.Article,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(1f)
                .background(Color.Green)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = article.title,
            style = TextStyle.Default.copy(fontSize = 14.sp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}
