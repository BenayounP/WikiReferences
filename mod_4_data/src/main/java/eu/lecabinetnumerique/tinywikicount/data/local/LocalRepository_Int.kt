package eu.lecabinetnumerique.tinywikicount.data.local

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

interface LocalRepository_Int {
    fun getLastSavedWikiReferencesModel() : WikiReferencesModel
    fun saveLastSavedSearch(wikiReferencesModel: WikiReferencesModel)
}