package app.soulcramer.machineacompose.symbols

import androidx.annotation.StringRes
import app.soulcramer.machineacompose.R

sealed class WashingIcon(
    override val iconRes: Int,
    override val textRes: Int,
    override val descriptionRes: Int
) : LaundrySymbol {
    override var isEnabled: Boolean = false
    override val categoryTitleRes: Int = R.string.washing
    override val categoryDescriptionRes: Int = R.string.washing_description

    object Washing : WashingIcon(R.drawable.ic_wash, R.string.wash, R.string.wash_description)
    object Washing30 : WashingIcon(R.drawable.ic_wash_30, R.string.wash, R.string.wash_description)
    object Washing40 : WashingIcon(R.drawable.ic_wash_40, R.string.wash, R.string.wash_description)
    object Washing50 : WashingIcon(R.drawable.ic_wash_50, R.string.wash, R.string.wash_description)
    object Washing60 : WashingIcon(R.drawable.ic_wash_60, R.string.wash, R.string.wash_description)
    object WashingHand : WashingIcon(R.drawable.ic_hand_wash, R.string.hand_wash, R.string.hand_wash_description)
    object NotWash : WashingIcon(R.drawable.ic_not_wash, R.string.not_wash, R.string.not_wash_description)

    companion object {
        fun getIcons(): List<WashingIcon> = listOf(
            Washing, Washing30, Washing40, Washing50, Washing60, WashingHand, NotWash
        )
    }
}