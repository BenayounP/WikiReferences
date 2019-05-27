package eu.lecabinetnumerique.tinywikicount.data

import eu.lecabinetnumerique.tinywikicount.data.model.ModelRepository_Int
import eu.lecabinetnumerique.tinywikicount.data.network.WikiAPIMngr_Int

import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel
import sun.rmi.runtime.Log

class Repository_Impl(var wikiAPIMngr: WikiAPIMngr_Int, var modelRepository_Int: ModelRepository_Int) : Repository_Int {

    var lastSavedWikiCountObservable = WikiReferencesModel.Observable()
    var searchStateObservable = SearchStateModel.Observable()

    init{
        lastSavedWikiCountObservable.getObserver().onChange = { oldValue, newValue ->
            modelRepository_Int.saveLastSavedSearch(newValue)}
    }

    override fun searchOccurrencesOnWiki(queryString: String) {
        wikiAPIMngr.searchOccurrencesOnWiki(queryString,lastSavedWikiCountObservable,searchStateObservable)
    }

    override fun getWikiReferencesObserver(): WikiReferencesModel.Observer {
        return lastSavedWikiCountObservable.getObserver()
    }

    override fun getSearchStateObserver(): SearchStateModel.Observer {
        return searchStateObservable.getObserver()
    }

    override fun getLastSavedWikiReferencesModel(): WikiReferencesModel {
        return modelRepository_Int.getLastSavedWikiReferencesModel()
    }
}