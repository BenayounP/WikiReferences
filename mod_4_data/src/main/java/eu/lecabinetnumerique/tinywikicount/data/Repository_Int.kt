package eu.lecabinetnumerique.tinywikicount.data

import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

interface Repository_Int {
    fun searchOccurrencesOnWiki(queryString: String)
    fun getWikiReferencesObserver(): WikiReferencesModel.Observer
    fun getSearchStateObserver(): SearchStateModel.Observer
}