package eu.lecabinetnumerique.tinywikicount.data.model

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

interface ModelRepository_Int {
    fun getLastSavedWikiReferencesModel() : WikiReferencesModel
    fun saveLastSavedSearch(wikiReferencesModel: WikiReferencesModel)
}