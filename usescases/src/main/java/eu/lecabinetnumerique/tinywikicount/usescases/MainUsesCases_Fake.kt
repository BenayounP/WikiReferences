package eu.lecabinetnumerique.tinywikicount.usescases

class MainUsesCases_Fake : MainUsesCases_Int {
    override fun getOccurrences(queryString: String): Int {
        return (1..1000).shuffled().first()
    }

    override fun getLastSearch(): String {
        return "";
    }
}