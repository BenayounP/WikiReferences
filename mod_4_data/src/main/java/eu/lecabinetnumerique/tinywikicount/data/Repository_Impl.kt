package eu.lecabinetnumerique.tinywikicount.data

import eu.lecabinetnumerique.tinywikicount.data.network.WikiAPIMngr_Int
import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

class Repository_Impl(var wikiAPIMngr: WikiAPIMngr_Int) : Repository_Int {

    var wikiCountObservable = WikiReferencesModel.Observable()
    var searchStateObservable = SearchStateModel.Observable()

    override fun searchOccurrencesOnWiki(queryString: String) {
        wikiAPIMngr.searchOccurrencesOnWiki(queryString,wikiCountObservable,searchStateObservable)
    }

    override fun getWikiReferencesObserver(): WikiReferencesModel.Observer {
        return wikiCountObservable.getObserver()
    }

    override fun getSearchStateObserver(): SearchStateModel.Observer {
        return searchStateObservable.getObserver()
    }
}