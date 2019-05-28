package eu.lecabinetnumerique.tinywikicount.data

import eu.lecabinetnumerique.tinywikicount.data.local.LocalRepository_Int
import eu.lecabinetnumerique.tinywikicount.data.network.WikiAPIMngr_Int

import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

class Repository_Impl(var wikiAPIMngr: WikiAPIMngr_Int, var localRepository_Int: LocalRepository_Int) : Repository_Int {

    var lastSavedWikiCountObservable = WikiReferencesModel.Observable()
    var searchStateObservable = SearchStateModel.Observable()

    init{
        lastSavedWikiCountObservable.getObserver().onChange = { oldValue, newValue ->
            localRepository_Int.saveLastSavedSearch(newValue)}
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

    override fun getLastSavedWikiReferencesModel(): WikiReferencesModel {
        return localRepository_Int.getLastSavedWikiReferencesModel()
    }
}