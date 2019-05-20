package eu.lecabinetnumerique.tinywikicount.domain

data class SearchModel(val query : String, val ocurrences : Int, val timestamp : Long = System.currentTimeMillis())