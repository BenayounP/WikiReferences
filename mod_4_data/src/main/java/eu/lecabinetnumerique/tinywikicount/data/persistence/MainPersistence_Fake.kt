package eu.lecabinetnumerique.tinywikicount.data.persistence

import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel

class MainPersistence_Fake : MainPersistence_Int {
    override fun saveLastSavedSearch(wikiCountModel: WikiCountModel) {
        // nothing to do -> it's fake !
    }

    override fun getLastSavedSearch(): WikiCountModel {
        return WikiCountModel("Liverpool", 2019);
    }
}