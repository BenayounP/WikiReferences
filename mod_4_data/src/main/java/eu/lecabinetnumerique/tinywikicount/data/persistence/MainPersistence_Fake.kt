package eu.lecabinetnumerique.tinywikicount.data.persistence

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

class MainPersistence_Fake : MainPersistence_Int {
    override fun saveLastSavedSearch(wikiReferencesModel: WikiReferencesModel) {
        // nothing to do -> it's fake !
    }

    override fun getLastSavedSearch(): WikiReferencesModel {
        return WikiReferencesModel("Liverpool", 2019);
    }
}