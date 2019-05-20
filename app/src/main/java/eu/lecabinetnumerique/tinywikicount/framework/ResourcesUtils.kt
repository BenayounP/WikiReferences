package eu.lecabinetnumerique.tinywikicount.framework

import android.content.Context
import android.content.res.Resources
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.domain.SearchModel

object ResourcesUtils {

    fun getSearchResultString(lastSearch : SearchModel, resources: Resources) : String{
        return when(lastSearch.ocurrences)
        {
            0 -> resources.getString(R.string.last_search_no_result)
            else -> resources.getQuantityString(R.plurals.last_search_result,lastSearch.ocurrences, lastSearch.query, lastSearch.ocurrences)
        }
    }


}