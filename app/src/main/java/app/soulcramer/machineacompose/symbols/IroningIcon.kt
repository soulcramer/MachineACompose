package app.soulcramer.machineacompose.symbols

import app.soulcramer.machineacompose.R

sealed class IronIcon(
    override val iconRes: Int,
    override val textRes: Int,
    override val descriptionRes: Int
) : LaundrySymbol {
    override var isEnabled: Boolean = false
    override val categoryTitleRes: Int = R.string.ironing
    override val categoryDescriptionRes: Int = R.string.ironing_description

    object IronLowTemp : IronIcon(R.drawable.ic_iron_low_temp, R.string.iron_low, R.string.iron_low_description)
    object IronMidTemp : IronIcon(R.drawable.ic_iron_mid_temp, R.string.iron_medium, R.string.iron_medium)
    object IronHighTemp : IronIcon(R.drawable.ic_iron_high_temp, R.string.iron_high, R.string.iron_high_description)
    object NotIron : IronIcon(R.drawable.ic_not_iron, R.string.not_iron, R.string.not_iron_description)

    companion object {
        fun getIcons(): List<IronIcon> = listOf(
            IronLowTemp, IronMidTemp, IronHighTemp, NotIron
        )
    }
}