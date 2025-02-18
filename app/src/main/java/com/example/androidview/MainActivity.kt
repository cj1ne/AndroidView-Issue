package com.example.androidview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidview.ui.theme.AndroidViewTheme

class MainActivity : ComponentActivity() {

    private val items = makeVerticalItems()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidViewTheme {
                MainScreen(items)
            }
        }
    }

    private fun makeVerticalItems(): ImmutableList<VerticalItem> {
        return ImmutableList(
            (1..500).map {
                if (it % 5 == 0) {
                    HorizontalListItem(
                        id = it.toString(),
                        title = "horizontal list item $it title",
                        articles = makeHorizontalItems(2)
                    )
                } else {
                    BasicItem(
                        id = "basic item $it",
                        publisher = "basic item $it publisher",
                        date = "2025.02.${(it % 10) + 10}",
                        articles = makeArticles()
                    )
                }
            }
        )
    }

    private fun makeArticles(): ImmutableList<BasicItem.Article> {
        return ImmutableList(
            (1..5).map {
                BasicItem.Article(
                    id = "basic item article $it",
                    title = "basic item article $it title",
                    description = "basic item article $it description",
                )
            }
        )
    }

    private fun makeHorizontalItems(count: Int): ImmutableList<HorizontalItem> {
        return ImmutableList(
            (1..count).map {
                if (it % 2 == 0) {
                    HorizontalComposeItem(
                        id = "horizontal compose item $it",
                        title = "horizontal compose item $it title",
                        description = "horizontal compose item $it description",
                    )
                } else {
                    HorizontalAndroidViewItem(
                        id = "horizontal android view item $it",
                        title = "horizontal android view item $it title",
                    )
                }
            }
        )
    }
}