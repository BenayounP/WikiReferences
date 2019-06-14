package eu.lecabinetnumerique.wikireferences.usecases

import eu.lecabinetnumerique.wikireferences.data.Data_Int
import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel

class UseCases_Impl(var data: Data_Int) : UseCases_Int {

    override fun getWikiReferencesObserver(): WikiReferencesModel.Observer {
        return data.getWikiReferencesObserver()
    }

    override fun searchReferencesOnWiki(queryString: String) {
        data.searchReferencesOnWiki(queryString)
    }

    override fun getSearchStateObserver(): SearchStateModel.Observer {
        return data.getSearchStateObserver()
    }
}