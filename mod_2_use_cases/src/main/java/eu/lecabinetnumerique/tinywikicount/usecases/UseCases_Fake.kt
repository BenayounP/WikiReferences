package eu.lecabinetnumerique.tinywikicount.usecases

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel

class UseCases_Fake : UseCases_Int {
    var fakeLastWikiSearchObservable = WikiCountModel.Observable()

    override fun searchOccurrencesOnWiki(queryString: String) {
        fakeLastWikiSearchObservable.wikiCountModel = WikiCountModel(queryString,(1..1000).shuffled().first())
    }

    override fun getWikiCountObserver(): WikiCountModel.Observer {
        return fakeLastWikiSearchObservable.getObserver()
    }
}