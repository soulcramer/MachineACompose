package app.soulcramer.machineacompose.data.repository

import app.soulcramer.machineacompose.data.Clothe
import app.soulcramer.machineacompose.data.room.ClotheDao
import com.dropbox.android.external.store4.Fetcher
import com.dropbox.android.external.store4.Store
import com.dropbox.android.external.store4.StoreBuilder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class ClotheStoreModule(
    private val clotheDao: ClotheDao
) {

    fun clotheStore(): Store<Int, List<Clothe>> = StoreBuilder.from<Int, List<Clothe>>(
        fetcher = Fetcher.ofFlow { clotheDao.loadAll() }
    ).build()
}