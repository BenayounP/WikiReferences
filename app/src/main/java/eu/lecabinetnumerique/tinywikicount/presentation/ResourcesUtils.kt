package eu.lecabinetnumerique.tinywikicount.presentation

import android.content.res.Resources
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel

object ResourcesUtils {

    fun getSearchResultString(lastWikiCount : WikiCountModel, resources: Resources) : String{
        return when(lastWikiCount.occurrences)
        {
            0 -> resources.getString(R.string.last_search_no_result)
            else -> resources.getQuantityString(R.plurals.last_search_result,lastWikiCount.occurrences, lastWikiCount.query, lastWikiCount.occurrences)
        }
    }
}