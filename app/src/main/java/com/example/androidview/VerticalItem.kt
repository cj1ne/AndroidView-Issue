package com.example.androidview

sealed interface VerticalItem {
    val id: String
}

data class BasicItem(
    override val id: String,
    val publisher: String,
    val date: String,
    val articles: ImmutableList<Article>,
) : VerticalItem {
    data class Article(
        val id: String,
        val title: String,
        val description: String,
    )
}

data class HorizontalListItem(
    override val id: String,
    val title: String,
    val articles: ImmutableList<HorizontalItem>,
) : VerticalItem