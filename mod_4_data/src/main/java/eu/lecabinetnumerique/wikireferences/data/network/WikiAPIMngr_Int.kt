package eu.lecabinetnumerique.wikireferences.data.network

import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel


interface WikiAPIMngr_Int {
    fun searchreferencesOnWiki(queryString: String, wikiReferencesModelObservable : WikiReferencesModel.Observable, searchStateObservable : SearchStateModel.Observable)
}