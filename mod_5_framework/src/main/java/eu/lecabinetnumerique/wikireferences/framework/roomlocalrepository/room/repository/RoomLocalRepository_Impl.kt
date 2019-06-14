package eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.repository

import eu.lecabinetnumerique.wikireferences.framework.MainApplication
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.SearchDao
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.SearchDataBase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class RoomLocalRepository_Impl() : AbstractRoomLocalRepository() {
    override fun getCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    override suspend fun getSearchDao(): SearchDao? {
        return SearchDataBase.getInstance(MainApplication.applicationContext())?.searchDao()
    }
}