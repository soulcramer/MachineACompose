package app.soulcramer.machineacompose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


val macGreen = Color(0xFF1EB980)
val macDarkGreen = Color(0xFF045D56)
val macOrange = Color(0xFFFF6859)
val macYellow = Color(0xFFFFCF44)
val macPurple = Color(0xFFB15DFF)
val macBlue = Color(0xFF72DEFF)

@Composable
fun MacTheme(children: @Composable () -> Unit) {
    val colors = if (!isSystemInDarkTheme()) {
        lightColors(
            primary = macGreen,
            primaryVariant = macDarkGreen,
            secondary = macOrange
        )
    } else {
        darkColors(
            primary = macDarkGreen,
            primaryVariant = macDarkGreen,
            secondary = macOrange
        )
    }
    MaterialTheme(
        colors = colors,
        shapes = Shapes(
            medium = RoundedCornerShape(8.dp),
            large = RoundedCornerShape(24.dp)
        ),
        content = children
    )
}