package app.soulcramer.machineacompose.data.room

import androidx.room.*
import app.soulcramer.machineacompose.data.Clothe
import kotlinx.coroutines.flow.Flow

/**
 * [Room] DAO for [Clothe] related operations.
 */
@Dao
abstract class ClotheDao {
    @Query("SELECT * FROM clothes")
    abstract fun loadAll(): Flow<List<Clothe>>

    @Query("SELECT COUNT(*) FROM clothes")
    abstract suspend fun count(): Int

    /**
     * The following methods should really live in a base interface. Unfortunately the Kotlin
     * Compiler which we need to use for Compose doesn't work with that.
     * TODO: remove this once we move to a more recent Kotlin compiler
     */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(entity: Clothe): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(entities: Collection<Clothe>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(entity: Clothe)

    @Delete
    abstract suspend fun delete(entity: Clothe): Int

    @Query("DELETE FROM clothes")
    abstract suspend fun deleteAll()
}