package eu.lecabinetnumerique.tinywikicount.usescases

import eu.lecabinetnumerique.tinywikicount.domain.SearchModel

interface MainUsesCases_Int {
    fun getOccurrences(queryString : String) : Int
    fun getLastSearch() : SearchModel
}