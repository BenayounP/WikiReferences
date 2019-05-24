package eu.lecabinetnumerique.tinywikicount.data

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel

class Repository_Fake : Repository_Int {
    var wikiCountObservable = WikiCountModel.Observable()

    override fun searchOccurrencesOnWiki(queryString: String) {
        wikiCountObservable.wikiCountModel = WikiCountModel(queryString,(1..1000).shuffled().first())
    }

    override fun getWikiCountObserver(): WikiCountModel.Observer {
        return wikiCountObservable.getObserver()
    }
}