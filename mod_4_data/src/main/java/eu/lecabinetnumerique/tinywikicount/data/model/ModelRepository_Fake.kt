package eu.lecabinetnumerique.tinywikicount.data.model

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

class ModelRepository_Fake : ModelRepository_Int {


    override fun getLastSavedWikiReferencesModel(): WikiReferencesModel {
        return WikiReferencesModel("Liverpool", 2019)
    }

    override fun saveLastSavedSearch(wikiReferencesModel: WikiReferencesModel) {
        // nothing to do -> fake
    }


}