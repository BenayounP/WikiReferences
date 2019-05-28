package eu.lecabinetnumerique.tinywikicount.usecases

import eu.lecabinetnumerique.tinywikicount.data.Repository_Int
import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

class UseCases_Impl(var repository: Repository_Int) : UseCases_Int{

    override fun getWikiCountObserver(): WikiReferencesModel.Observer {
        return repository.getWikiReferencesObserver()
    }

    override fun searchReferencesOnWiki(queryString: String) {
        repository.searchReferencesOnWiki(queryString)
    }

    override fun getSearchStateObserver(): SearchStateModel.Observer {
        return repository.getSearchStateObserver()
    }
    override fun getLastSavedWikiReferencesModel(): WikiReferencesModel {
        return repository.getLastSavedWikiReferencesModel()
    }

}