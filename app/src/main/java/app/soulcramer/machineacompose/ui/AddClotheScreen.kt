package app.soulcramer.machineacompose.ui

import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.ripple.RippleIndication
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import app.soulcramer.machineacompose.symbols.LaundrySymbol
import app.soulcramer.machineacompose.symbols.WashingIcon

@Composable
fun AddClothe(
    modifier: Modifier
) {

    val viewModel: AddClotheViewModel = viewModel(
        factory = AddClotheViewModelFactory()
    )

    viewModel.liveData.observeAsState().value?.let { addClotheState ->
        ScrollableColumn(modifier) {
            LaundrySymbolsList(addClotheState.washSymbols)
            LaundrySymbolsList(addClotheState.bleachSymbols)
            LaundrySymbolsList(addClotheState.drySymbols)
            LaundrySymbolsList(addClotheState.ironSymbols)
        }
    }
}

@Composable
fun LaundrySymbolsList(symbols: List<LaundrySymbol>) {
    if (symbols.isEmpty()) return
    val firstSymbol = symbols[0]
    Card(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = stringResource(firstSymbol.categoryTitleRes),
                modifier = Modifier.padding(start = 12.dp, top = 12.dp),
                style = MaterialTheme.typography.body1
            )
            ScrollableRow(
                Modifier.padding(horizontal = 8.dp)
            ) {
                symbols.forEach {
                    LaundryIcon(it)
                }
            }
        }
    }
}

@Composable
fun LaundryIcon(
    laundrySymbol: LaundrySymbol,
    onLongPress: (laundrySymbol: LaundrySymbol) -> Unit = {}
) {
    val (isSelected, setIsSelected) = remember { mutableStateOf(laundrySymbol.isEnabled) }
    val symbolColor = if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.2f) else Color.Transparent

    Surface(
        modifier = Modifier.padding(vertical = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .toggleable(
                value = isSelected,
                onValueChange = setIsSelected,
                indication = RippleIndication(bounded = true, color = MaterialTheme.colors.primaryVariant)
            )
            .longPressGestureFilter {
                onLongPress(laundrySymbol)
            },
        color = symbolColor
    ) {
        val image = vectorResource(laundrySymbol.iconRes)
        Stack(
            modifier = Modifier.padding(8.dp).preferredSize(56.dp, 56.dp),
            alignment = Alignment.Center
        ) {
            val iconColor = if (isSelected) {
                MaterialTheme.colors.primaryVariant
            } else {
                MaterialTheme.colors.onSurface
            }
            Icon(image, tint = iconColor)
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
    LaundryIcon(WashingIcon.WashingHand)
}