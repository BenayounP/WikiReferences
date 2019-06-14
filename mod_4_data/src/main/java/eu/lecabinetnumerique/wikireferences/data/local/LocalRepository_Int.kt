package eu.lecabinetnumerique.wikireferences.data.local

import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel

interface LocalRepository_Int {
    fun getLastSavedWikiReferencesModel() : WikiReferencesModel
    fun saveLastSavedSearch(wikiReferencesModel: WikiReferencesModel)
}