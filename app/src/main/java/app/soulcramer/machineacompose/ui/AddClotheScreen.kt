package app.soulcramer.machineacompose.ui

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Stack
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.gesture.longPressGestureFilter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import app.soulcramer.machineacompose.MacApp
import app.soulcramer.machineacompose.symbols.*

@Composable
fun AddClothe(modifier: Modifier) {
    val washingSymbols = WashingIcon.getIcons()
    val beachingSymbols = BleachingIcon.getIcons()
    val dryingSymbols = DryingIcon.getIcons()
    val ironSymbols = IronIcon.getIcons()
    ScrollableColumn(modifier) {
        LaundrySymbolsList(washingSymbols)
        LaundrySymbolsList(beachingSymbols)
        LaundrySymbolsList(dryingSymbols)
        LaundrySymbolsList(ironSymbols)
        LaundrySymbolsList(ironSymbols)
        LaundrySymbolsList(ironSymbols)
        LaundrySymbolsList(ironSymbols)
        LaundrySymbolsList(ironSymbols)
    }
}

@Composable
fun LaundrySymbolsList(symbols: List<LaundrySymbol>) {
    if(symbols.isEmpty()) return
    val firstSymbol = symbols[0]
    Card(modifier = Modifier.padding(16.dp), shape = RoundedCornerShape(8.dp)) {
        Column() {
            Text(
                text = stringResource(firstSymbol.categoryTitleRes),
                modifier = Modifier.padding(start = 12.dp, top= 12.dp),
                style = MaterialTheme.typography.body1
            )
            ScrollableRow(
                Modifier.padding(horizontal = 8.dp)
            ) {
                symbols.forEach {
                    Icon(it)
                }
            }
        }
    }
}

@Composable
fun Icon(laundrySymbol: LaundrySymbol) {
    val (isSelected, setIsSelected) = remember { mutableStateOf(laundrySymbol.isEnabled) }
    val symbolColor = if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.2f) else Color.Transparent

    Surface(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .toggleable(
                value = isSelected,
                onValueChange = setIsSelected,
                indication = RippleIndication(bounded = true, color = MaterialTheme.colors.primaryVariant)
            )
            .longPressGestureFilter {

            },
        color = symbolColor
    ) {
        val image = vectorResource(laundrySymbol.iconRes)
        Stack(
            modifier = Modifier.preferredSize(72.dp, 72.dp),
            alignment = Alignment.Center
        ) {
            val iconColor = if (isSelected) {
                MaterialTheme.colors.primaryVariant
            } else {
                MaterialTheme.colors.onSurface
            }
            androidx.compose.foundation.Icon(image, tint = iconColor)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    AddClothe(Modifier)
}

@Preview()
@Composable
fun LaundrySymbolsListPreview() {
    LaundrySymbolsList(WashingIcon.getIcons())
}

@Preview
@Composable
fun IconPreview() {
    Icon(WashingIcon.WashingHand)
}