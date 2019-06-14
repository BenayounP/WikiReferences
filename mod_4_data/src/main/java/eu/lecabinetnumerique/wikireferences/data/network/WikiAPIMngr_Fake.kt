package eu.lecabinetnumerique.wikireferences.data.network

import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel

class WikiAPIMngr_Fake : WikiAPIMngr_Int {

    // for tests, allow to force references for a query
    var nextQueryAmountOfReferences = (1..1000).shuffled().first()

    // used for setting success or error on search
    private var errorMode = false

    fun setErrorModeON()
    {
        errorMode = true;
    }

    fun setErrorModeOFF()
    {
        errorMode = false;
    }

    override fun searchreferencesOnWiki(queryString: String, wikiReferencesModelObservable: WikiReferencesModel.Observable, searchStateObservable : SearchStateModel.Observable) {
        searchStateObservable.searchState = SearchStateModel.Searching;
        if (errorMode==false) {
            wikiReferencesModelObservable.wikiReferencesModel =
                WikiReferencesModel(
                    queryString, nextQueryAmountOfReferences
                )
            searchStateObservable.searchState = SearchStateModel.Idle;
        }
        else
        {
            searchStateObservable.searchState = SearchStateModel.Error;
        }
    }

}