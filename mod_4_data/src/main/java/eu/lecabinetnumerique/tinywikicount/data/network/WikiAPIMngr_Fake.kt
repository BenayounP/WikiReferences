package eu.lecabinetnumerique.tinywikicount.data.network

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel

class WikiAPIMngr_Fake : WikiAPIMngr_Int {

    override fun searchOccurrencesOnWiki(queryString: String, wikiCountModelObservable: WikiCountModel.Observable) {
        wikiCountModelObservable.wikiCountModel = WikiCountModel(queryString,(1..1000).shuffled().first())
    }

}