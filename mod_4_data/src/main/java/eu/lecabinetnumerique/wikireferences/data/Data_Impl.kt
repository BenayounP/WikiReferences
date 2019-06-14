package eu.lecabinetnumerique.wikireferences.data

import eu.lecabinetnumerique.wikireferences.data.local.LocalRepository_Int
import eu.lecabinetnumerique.wikireferences.data.network.WikiAPIMngr_Int

import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel

class Data_Impl(var wikiAPIMngr: WikiAPIMngr_Int, var localRepository_Int: LocalRepository_Int) : Data_Int {

    var lastSavedWikiCountObservable = WikiReferencesModel.Observable()
    var searchStateObservable = SearchStateModel.Observable()

    init{
        lastSavedWikiCountObservable.getObserver().onChange = { oldValue, newValue ->
            localRepository_Int.saveLastSavedSearch(newValue)}
        lastSavedWikiCountObservable.wikiReferencesModel = localRepository_Int.getLastSavedWikiReferencesModel()
    }

    override fun searchReferencesOnWiki(queryString: String) {
        wikiAPIMngr.searchreferencesOnWiki(queryString,lastSavedWikiCountObservable,searchStateObservable)
    }

    override fun getWikiReferencesObserver(): WikiReferencesModel.Observer {
        return lastSavedWikiCountObservable.getObserver()
    }

    override fun getSearchStateObserver(): SearchStateModel.Observer {
        return searchStateObservable.getObserver()
    }


}