package eu.lecabinetnumerique.wikireferences.usecases

import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel

class UseCases_Fake : UseCases_Int {

    private val lastWikiSearchObservable = WikiReferencesModel.Observable()
    private val searchStateModel = SearchStateModel.Observable()

    init{
        lastWikiSearchObservable.wikiReferencesModel = WikiReferencesModel("Liverpool",2019)
    }

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

    override fun searchReferencesOnWiki(queryString: String) {
        searchStateModel.searchState = SearchStateModel.Searching;
        if (errorMode==false) {
            lastWikiSearchObservable.wikiReferencesModel =
                WikiReferencesModel(
                    queryString, nextQueryAmountOfReferences
                )
            searchStateModel.searchState = SearchStateModel.Idle;
        }
        else
        {
            searchStateModel.searchState = SearchStateModel.Error;
        }
    }

    override fun getWikiReferencesObserver(): WikiReferencesModel.Observer {
        return lastWikiSearchObservable.getObserver()
    }

    override fun getSearchStateObserver(): SearchStateModel.Observer {
        return searchStateModel.getObserver()
    }
}