package eu.lecabinetnumerique.tiniwikicount.framework.roomlocalrepository

import eu.lecabinetnumerique.tiniwikicount.framework.roomlocalrepository.room.SearchDataBase
import eu.lecabinetnumerique.tiniwikicount.framework.roomlocalrepository.room.SearchEntity
import eu.lecabinetnumerique.tinywikicount.data.local.LocalRepository_Int
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel
import kotlinx.coroutines.*

class RoomLocalRepository_Impl : LocalRepository_Int {


    override fun getLastSavedWikiReferencesModel(): WikiReferencesModel {
        var dataBaseWikiReferenceModel = runBlocking { CoroutineScope(Dispatchers.IO).async { SearchDataBase.getInstance()?.searchDao()?.getLastSearch()?.getWikiReferenceModel() ?: WikiReferencesModel()}.await()}
        return dataBaseWikiReferenceModel
    }

    override fun saveLastSavedSearch(wikiReferencesModel: WikiReferencesModel) {
        var searchEntity = SearchEntity()
        searchEntity.setColumns(wikiReferencesModel)
        runBlocking { CoroutineScope(Dispatchers.IO).launch {SearchDataBase.getInstance()?.searchDao()?.insert(searchEntity)}}
    }

}