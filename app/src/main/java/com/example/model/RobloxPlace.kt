package com.example.model

import androidx.compose.ui.graphics.Color

data class PlaceScene(
    val emoji: String,
    val enHint: String,
    val ruHint: String,
    val themeColor: Color
)

data class RobloxPlace(
    val id: String,
    val enName: String,
    val ruName: String,
    val enHint: String,
    val ruHint: String,
    val emoji: String,
    val themeColor: Color,
    val category: String,
    val difficulty: String,
    val scenes: List<PlaceScene> = emptyList()
)
