package eu.lecabinetnumerique.tinywikicount.data

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel

interface Repository_Int {
    fun searchOccurrencesOnWiki(queryString: String)
    fun getWikiCountObserver(): WikiCountModel.Observer
}