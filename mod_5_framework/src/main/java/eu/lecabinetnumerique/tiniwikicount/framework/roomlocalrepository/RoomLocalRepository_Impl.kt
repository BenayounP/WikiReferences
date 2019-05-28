package eu.lecabinetnumerique.tiniwikicount.framework.roomlocalrepository

import eu.lecabinetnumerique.tiniwikicount.framework.roomlocalrepository.room.SearchDataBase
import eu.lecabinetnumerique.tiniwikicount.framework.roomlocalrepository.room.SearchEntity
import eu.lecabinetnumerique.tinywikicount.data.local.LocalRepository_Int
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

class RoomLocalRepository_Impl : LocalRepository_Int {

    private val searchDataBase  by lazy {
        SearchDataBase.getInstance()
    }

    override fun getLastSavedWikiReferencesModel(): WikiReferencesModel {
        var dataBaseWikiReferenceModel = searchDataBase?.searchDao()?.getLastSearch()?.getWikiReferenceModel() ?: WikiReferencesModel()
        return dataBaseWikiReferenceModel
    }

    override fun saveLastSavedSearch(wikiReferencesModel: WikiReferencesModel) {
        var searchEntity = SearchEntity()
        searchEntity.setColumns(wikiReferencesModel)
        searchDataBase?.searchDao()?.insert(searchEntity)
    }



}