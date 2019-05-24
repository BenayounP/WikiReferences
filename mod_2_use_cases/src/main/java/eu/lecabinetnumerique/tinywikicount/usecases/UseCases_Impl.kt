package eu.lecabinetnumerique.tinywikicount.usecases

import eu.lecabinetnumerique.tinywikicount.data.Repository_Int
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel

class UseCases_Impl(var repository: Repository_Int) : UseCases_Int{
    override fun getWikiCountObserver(): WikiCountModel.Observer {
        return repository.getWikiCountObserver()
    }

    override fun searchOccurrencesOnWiki(queryString: String) {
        repository.searchOccurrencesOnWiki(queryString)
    }

}