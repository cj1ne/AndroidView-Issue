package com.example.androidview

import androidx.compose.runtime.Immutable

@Immutable
data class ImmutableList<T>(val value: List<T> = emptyList())