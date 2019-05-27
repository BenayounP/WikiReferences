package eu.lecabinetnumerique.tinywikicount.usecases

import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

class UseCases_Fake : UseCases_Int {

    val fakeLastWikiSearchObservable = WikiReferencesModel.Observable()
    val fakeSearchStateModel = SearchStateModel.Observable()

    override fun searchOccurrencesOnWiki(queryString: String) {
        fakeLastWikiSearchObservable.wikiReferencesModel = WikiReferencesModel(queryString,(1..1000).shuffled().first())
    }

    override fun getWikiCountObserver(): WikiReferencesModel.Observer {
        return fakeLastWikiSearchObservable.getObserver()
    }

    override fun getSearchStateObserver(): SearchStateModel.Observer {
        return fakeSearchStateModel.getObserver()
    }
}