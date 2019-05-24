package eu.lecabinetnumerique.tiniwikicount.framework.network

class WikiAPIJSonModel {
    data class Result(val query: Query)
    data class Query(val searchinfo: SearchInfo)
    data class SearchInfo(val totalhits: Int)
}
