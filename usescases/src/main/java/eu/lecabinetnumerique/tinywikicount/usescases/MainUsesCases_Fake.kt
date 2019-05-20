package eu.lecabinetnumerique.tinywikicount.usescases

import eu.lecabinetnumerique.tinywikicount.domain.SearchModel

class MainUsesCases_Fake : MainUsesCases_Int {
    override fun getOccurrences(queryString: String): Int {
        return (1..1000).shuffled().first()
    }

    override fun getLastSearch(): SearchModel {
        return SearchModel("Liverpool",2019);
    }
}