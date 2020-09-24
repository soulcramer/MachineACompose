package app.soulcramer.machineacompose.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.soulcramer.machineacompose.data.Clothe

/**
 * The [RoomDatabase] we use in this app.
 */
@Database(
    entities = [
        Clothe::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MacDatabase : RoomDatabase() {
    abstract fun podcastsDao(): ClotheDao
}