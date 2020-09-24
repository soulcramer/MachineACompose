package app.soulcramer.machineacompose.data.room

import androidx.room.TypeConverter
import app.soulcramer.machineacompose.data.Bleach
import app.soulcramer.machineacompose.data.Dry
import app.soulcramer.machineacompose.data.Iron
import app.soulcramer.machineacompose.data.Wash

class Converters {
    @TypeConverter
    fun toWash(value: String) = enumValueOf<Wash>(value)

    @TypeConverter
    fun fromWash(value: Wash) = value.name

    @TypeConverter
    fun toBleach(value: String) = enumValueOf<Bleach>(value)

    @TypeConverter
    fun fromBleach(value: Bleach) = value.name

    @TypeConverter
    fun toDry(value: String) = enumValueOf<Dry>(value)

    @TypeConverter
    fun fromDry(value: Dry) = value.name

    @TypeConverter
    fun toIron(value: String) = enumValueOf<Iron>(value)

    @TypeConverter
    fun fromIron(value: Iron) = value.name
}