package eu.lecabinetnumerique.wikireferences.data

import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel

interface Data_Int {
    // will launch a search on wikipedia
    // That will change last saved WikiReferenceModel and save it if it's a success
    // it will change the searchState data if there is an error
    fun searchReferencesOnWiki(queryString: String)

    // get an observer on WikiReferencesModel that represents the last search
    fun getWikiReferencesObserver(): WikiReferencesModel.Observer

    // get an observer on current search state
    fun getSearchStateObserver(): SearchStateModel.Observer
}