package eu.lecabinetnumerique.tinywikicount.data.persistence

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

interface MainPersistence_Int {
    fun getLastSavedSearch(): WikiReferencesModel
    fun saveLastSavedSearch(wikiReferencesModel: WikiReferencesModel)
}