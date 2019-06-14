package eu.lecabinetnumerique.wikireferences.framework.network

class WikiAPIJSonModel {
    data class Result(val query: Query)
    data class Query(val searchinfo: SearchInfo)
    data class SearchInfo(val totalhits: Int)
}
