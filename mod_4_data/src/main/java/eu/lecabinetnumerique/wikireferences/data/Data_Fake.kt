package eu.lecabinetnumerique.wikireferences.data

import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel

class Data_Fake : Data_Int {

    var wikiCountObservable = WikiReferencesModel.Observable()
    var searchStateObservable = SearchStateModel.Observable()

    override fun searchReferencesOnWiki(queryString: String) {
        wikiCountObservable.wikiReferencesModel =
            WikiReferencesModel(
                queryString,
                (1..1000).shuffled().first()
            )
    }

    override fun getWikiReferencesObserver(): WikiReferencesModel.Observer {
        return wikiCountObservable.getObserver()
    }

    override fun getSearchStateObserver(): SearchStateModel.Observer {
        return searchStateObservable.getObserver()
    }


}