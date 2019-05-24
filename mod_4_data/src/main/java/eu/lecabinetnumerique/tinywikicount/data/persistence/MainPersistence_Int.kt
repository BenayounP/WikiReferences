package eu.lecabinetnumerique.tinywikicount.data.persistence

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel

interface MainPersistence_Int {
    fun getLastSavedSearch(): WikiCountModel
    fun saveLastSavedSearch(wikiCountModel: WikiCountModel)
}