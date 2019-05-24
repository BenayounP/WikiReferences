package eu.lecabinetnumerique.tinywikicount.usecases

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel

interface UseCases_Int {
    fun searchOccurrencesOnWiki(queryString: String)
    fun getWikiCountObserver(): WikiCountModel.Observer
}