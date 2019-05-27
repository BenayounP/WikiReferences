package eu.lecabinetnumerique.tinywikicount.data.network

import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel


interface WikiAPIMngr_Int {
    fun searchOccurrencesOnWiki(queryString: String, wikiReferencesModelObservable : WikiReferencesModel.Observable,searchStateObservable : SearchStateModel.Observable)
}