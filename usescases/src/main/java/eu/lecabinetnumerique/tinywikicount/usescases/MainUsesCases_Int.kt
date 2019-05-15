package eu.lecabinetnumerique.tinywikicount.usescases

interface MainUsesCases_Int {
    fun getOccurrences(queryString : String) : Int
    fun getLastSearch() : String
}