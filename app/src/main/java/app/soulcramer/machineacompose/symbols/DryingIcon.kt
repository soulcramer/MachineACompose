package app.soulcramer.machineacompose.symbols

import app.soulcramer.machineacompose.R

sealed class DryingIcon(
    override val iconRes: Int,
    override val textRes: Int,
    override val descriptionRes: Int
) : LaundrySymbol {
    override var isEnabled: Boolean = false
    override val categoryTitleRes: Int = R.string.bleaching
    override val categoryDescriptionRes: Int = R.string.bleaching_description

    object DryingDrip : DryingIcon(R.drawable.ic_drying_drip, R.string.dry_drip, R.string.dry_drip_description)
    object DryingFlat : DryingIcon(R.drawable.ic_drying_flat, R.string.dry_flat, R.string.dry_flat_description)
    object DryingFlatInShade : DryingIcon(R.drawable.ic_drying_flat_in_shade, R.string.dry_flat_in_shade, R.string.dry_flat_in_shade_description)
    object DryingInShade : DryingIcon(R.drawable.ic_drying_in_shade, R.string.dry_in_shade, R.string.dry_in_shade_description)
    object DryingTumbleLowTemp : DryingIcon(R.drawable.ic_tumble_drying_low_temp, R.string.dry_thumble_low_temp, R.string.dry_thumble_low_temp_description)
    object DryingTumbleNormalTemp : DryingIcon(R.drawable.ic_tumble_drying_normal_temp, R.string.dry_thumble_normal_temp, R.string.dry_thumble_normal_temp_description)
    object NotThumbleDry : DryingIcon(R.drawable.ic_not_tumble_dry, R.string.not_dry_thumble, R.string.not_dry_thumble_description)

    companion object {
        fun getIcons(): List<DryingIcon> = listOf(
            DryingDrip, DryingFlat, DryingFlatInShade, DryingInShade,
            DryingTumbleLowTemp, DryingTumbleNormalTemp, NotThumbleDry
        )
    }
}