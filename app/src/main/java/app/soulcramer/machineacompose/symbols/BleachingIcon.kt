package app.soulcramer.machineacompose.symbols

import app.soulcramer.machineacompose.R

sealed class BleachingIcon(
    override val iconRes: Int,
    override val textRes: Int,
    override val descriptionRes: Int
) : LaundrySymbol {
    override var isEnabled: Boolean = false
    override val categoryTitleRes: Int = R.string.bleaching
    override val categoryDescriptionRes: Int = R.string.bleaching_description

    object Bleaching : BleachingIcon(R.drawable.ic_bleaching, R.string.bleach, R.string.bleach_description)
    object BleachingChlorine : BleachingIcon(R.drawable.ic_bleaching_chlorine, R.string.bleach_chlorine, R.string.bleach_chlorine_description)
    object BleachingNoChlorine : BleachingIcon(R.drawable.ic_bleaching_non_chlorine, R.string.bleach_non_chlorine, R.string.bleach_non_chlorine_description)
    object NotBleach : BleachingIcon(R.drawable.ic_non_bleaching, R.string.not_bleach, R.string.not_bleach_description)

    companion object {
        fun getIcons(): List<BleachingIcon> = listOf(
            Bleaching, BleachingChlorine, BleachingNoChlorine, NotBleach
        )
    }
}