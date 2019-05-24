package eu.lecabinetnumerique.tinywikicount.data

import eu.lecabinetnumerique.tinywikicount.data.network.WikiAPIMngr_Int
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel

class Repository_Impl(var wikiAPIMngr: WikiAPIMngr_Int) : Repository_Int {

    var wikiCountObservable = WikiCountModel.Observable();

    override fun searchOccurrencesOnWiki(queryString: String) {
        wikiAPIMngr.searchOccurrencesOnWiki(queryString,wikiCountObservable)
    }

    override fun getWikiCountObserver(): WikiCountModel.Observer {
        return wikiCountObservable.getObserver()
    }
}