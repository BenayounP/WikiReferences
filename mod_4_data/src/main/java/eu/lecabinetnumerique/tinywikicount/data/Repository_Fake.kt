package eu.lecabinetnumerique.tinywikicount.data

import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

class Repository_Fake : Repository_Int {

    var wikiCountObservable = WikiReferencesModel.Observable()
    var searchStateObservable = SearchStateModel.Observable()

    override fun searchOccurrencesOnWiki(queryString: String) {
        wikiCountObservable.wikiReferencesModel = WikiReferencesModel(queryString,(1..1000).shuffled().first())
    }

    override fun getWikiReferencesObserver(): WikiReferencesModel.Observer {
        return wikiCountObservable.getObserver()
    }

    override fun getSearchStateObserver(): SearchStateModel.Observer {
        return searchStateObservable.getObserver()
    }

    override fun getLastSavedWikiReferencesModel(): WikiReferencesModel {
        return WikiReferencesModel("Liverpool",2019)
    }
}