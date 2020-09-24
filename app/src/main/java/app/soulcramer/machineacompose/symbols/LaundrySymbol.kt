package app.soulcramer.machineacompose.symbols

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface LaundrySymbol {
    var isEnabled : Boolean
    @get:DrawableRes val iconRes: Int
    @get:StringRes val textRes: Int
    @get:StringRes val descriptionRes: Int

    @get:StringRes val categoryTitleRes: Int
    @get:StringRes val categoryDescriptionRes: Int
}