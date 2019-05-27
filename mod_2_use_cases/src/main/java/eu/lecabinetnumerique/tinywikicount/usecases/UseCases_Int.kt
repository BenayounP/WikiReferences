package eu.lecabinetnumerique.tinywikicount.usecases

import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

interface UseCases_Int {
    fun searchOccurrencesOnWiki(queryString: String)
    fun getWikiCountObserver(): WikiReferencesModel.Observer
    fun getSearchStateObserver(): SearchStateModel.Observer
    fun getLastSavedWikiReferencesModel() : WikiReferencesModel
}