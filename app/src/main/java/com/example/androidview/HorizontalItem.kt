package com.example.androidview

sealed interface HorizontalItem {
    val id: String
}

data class HorizontalComposeItem(
    override val id: String,
    val title: String,
    val description: String,
): HorizontalItem

data class HorizontalAndroidViewItem(
    override val id: String,
    val title: String,
): HorizontalItem