package eu.lecabinetnumerique.wikireferences.data.local

import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel

class LocalRepository_Fake : LocalRepository_Int {


    override fun getLastSavedWikiReferencesModel(): WikiReferencesModel {
        return WikiReferencesModel("Liverpool", 2019)
    }

    override fun saveLastSavedSearch(wikiReferencesModel: WikiReferencesModel) {
        // nothing to do -> fake
    }


}