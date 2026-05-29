package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = NeonTeal,
    onPrimary = DarkBg,
    primaryContainer = CardBg,
    onPrimaryContainer = SoftWhite,
    secondary = NeonRed,
    onSecondary = SoftWhite,
    secondaryContainer = InputBg,
    onSecondaryContainer = CoolGray,
    background = DarkBg,
    onBackground = SoftWhite,
    surface = CardBg,
    onSurface = SoftWhite,
    tertiary = GoldStar,
    onTertiary = DarkBg,
    error = NeonRed,
    onError = SoftWhite
)

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
