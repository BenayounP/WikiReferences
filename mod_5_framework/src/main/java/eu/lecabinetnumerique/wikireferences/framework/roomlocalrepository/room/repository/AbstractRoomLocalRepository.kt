package eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.repository

import android.util.Log
import eu.lecabinetnumerique.wikireferences.data.local.LocalRepository_Int
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.SearchDao
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.SearchEntity
import kotlinx.coroutines.*

abstract class AbstractRoomLocalRepository() : LocalRepository_Int {


    override fun getLastSavedWikiReferencesModel(): WikiReferencesModel {
        var dataBaseWikiReferenceModel = runBlocking { CoroutineScope(getCoroutineDispatcher()).async { getSearchDao()?.getLastSearch()?.getWikiReferenceModel() ?: WikiReferencesModel() }.await()}
        Log.d("TWC", "getLastSavedWikiReferencesModel: ${dataBaseWikiReferenceModel}" )
        return dataBaseWikiReferenceModel
    }

    override fun saveLastSavedSearch(wikiReferencesModel: WikiReferencesModel) {
        runBlocking { CoroutineScope(getCoroutineDispatcher()).async { upsert(wikiReferencesModel)}.await()}
    }

    private suspend fun upsert(wikiReferencesModel: WikiReferencesModel)
    {
        var searchEntity = SearchEntity()
        searchEntity.setColumns(wikiReferencesModel)

        var dataBaseWikiReferenceModel = getSearchDao()?.getLastSearch()?.getWikiReferenceModel()
        if (dataBaseWikiReferenceModel==null)
        {
            getSearchDao()?.insert(searchEntity)
        }
        else
        {
            getSearchDao()?.update(searchEntity)
        }
    }

    abstract suspend fun getSearchDao() : SearchDao?

    abstract fun getCoroutineDispatcher() : CoroutineDispatcher
}