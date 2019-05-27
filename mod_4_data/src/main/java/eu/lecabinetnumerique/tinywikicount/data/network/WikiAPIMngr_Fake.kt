package eu.lecabinetnumerique.tinywikicount.data.network

import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

class WikiAPIMngr_Fake : WikiAPIMngr_Int {

    override fun searchOccurrencesOnWiki(queryString: String, wikiReferencesModelObservable: WikiReferencesModel.Observable,searchStateObservable : SearchStateModel.Observable) {
        wikiReferencesModelObservable.wikiReferencesModel = WikiReferencesModel(queryString,(1..1000).shuffled().first())
    }

}