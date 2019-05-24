package eu.lecabinetnumerique.tinywikicount.data.network

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel


interface WikiAPIMngr_Int {
    fun searchOccurrencesOnWiki(queryString: String, wikiCountModelObservable : WikiCountModel.Observable)
}