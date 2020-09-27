package app.soulcramer.machineacompose.ui.color

import androidx.compose.foundation.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.gesture.scrollorientationlocking.Orientation
import androidx.compose.ui.gesture.tapGestureFilter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.HorizontalGradient
import androidx.compose.ui.platform.DensityAmbient
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import android.graphics.Color as AndroidColor

/**
 * Gradient color picker
 *
 * @sample dev.sasikanth.colorpicker.ColorPickerPreview
 */
@Composable
fun ColorPicker(
    pickerHeight: Dp = 24.dp,
    colorSelected: (Color) -> Unit
) {
    WithConstraints {
        // Since we start from hue 0 setting the default selected color
        // to red, but need to find a better way of getting initial color.
        val selectedColor = remember { mutableStateOf(Color.Red) }
        val position = remember { mutableStateOf(0f) }

        val squareSizePx = with(DensityAmbient.current) {
            pickerHeight.toPx()
        }
        val pickerWidthPx = with(DensityAmbient.current) {
            maxWidth.toPx()
        }
        val pickerMaxWidth = pickerWidthPx - squareSizePx

        val horizontalGradient = HorizontalGradient(
            colors = colors(),
            startX = 0f,
            endX = pickerWidthPx
        )
        val roundedCornerShape = RoundedCornerShape(pickerHeight / 2)

        val drag = Modifier.draggable(
            orientation = Orientation.Horizontal,
            onDragStarted = {
                position.value = it.x
            }
        ) { delta ->
            val old = position.value
            // Making sure the sum of delta and position is within the 0 and
            // max width of picker view
            position.value = (delta + position.value).coerceIn(0f, pickerMaxWidth)

            val hsvColor = getHsvColor(position.value, pickerMaxWidth)
            selectedColor.value = Color(hsvColor)
            colorSelected(selectedColor.value)

            position.value - old
        }


        // Color Picker View
        Box(
            modifier = drag
                .tapGestureFilter {
                    position.value = it.x
                    val hsvColor = getHsvColor(position.value, pickerMaxWidth)
                    selectedColor.value = Color(hsvColor)
                    colorSelected(selectedColor.value)
                }.height(pickerHeight)
                .width(maxWidth)
                .clip(shape = roundedCornerShape)
                .background(brush = horizontalGradient, shape = roundedCornerShape)
        ) {

            val xOffset = with(DensityAmbient.current) { position.value.toDp() }
            val squareSize = with(DensityAmbient.current) { squareSizePx.toDp() }

            // Square box to show the preview of selected color
            Box(
                Modifier
                    .offset(x = xOffset, y = 0.dp)
                    .width(squareSize)
                    .height(squareSize)
                    .border(width = 2.dp, color = Color.White, shape = roundedCornerShape)
                    .drawShadow(elevation = 2.dp, shape = roundedCornerShape),
                shape = roundedCornerShape,
                backgroundColor = selectedColor.value
            )

        }
    }
}

private fun getHsvColor(position: Float, maxWidth: Float): Int {
    // dividing the position of drag by max width of the picker view
    // and then we multiply it by 359 which is the final HUE value
    val hue = (position / maxWidth) * 359f
    return AndroidColor.HSVToColor(floatArrayOf(hue, 1f, 1f))
}


val purple200 = Color(0xFFBB86FC)
val purple500 = Color(0xFF6200EE)
val purple700 = Color(0xFF3700B3)
val teal200 = Color(0xFF03DAC5)

fun colors(): List<Color> {
    val colorRange = 0..359
    return colorRange.map {
        val hsvColor = AndroidColor.HSVToColor(floatArrayOf(it.toFloat(), 1f, 1f))
        Color(hsvColor)
    }
}

@Preview(
    name = "ColorPicker",
    widthDp = 320,
    heightDp = 48
)
@Composable
fun ColorPickerPreview() {
    Box(
        gravity = Alignment.Center,
        modifier = Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp)
    ) {
        ColorPicker {}
    }
}