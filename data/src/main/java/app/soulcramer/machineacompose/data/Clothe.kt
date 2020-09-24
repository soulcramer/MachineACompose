package app.soulcramer.machineacompose.data

import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "clothes",
    indices = [
        Index("id", unique = true),
        Index("color"),
    ]
)
@Immutable
data class Clothe(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "color") val color: String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "brand") val brand: String,
    @ColumnInfo(name = "material") val material: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "wash") val wash: Wash?,
    @ColumnInfo(name = "bleach") val bleach: Bleach?,
    @ColumnInfo(name = "dry") val dry: Dry?,
    @ColumnInfo(name = "iron") val iron: Iron?,
)