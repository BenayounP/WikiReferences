package eu.lecabinetnumerique.tinywikicount.presentation

import android.content.res.Resources
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel

object ResourcesUtils {

    fun getSearchResultString(lastWikiReferences : WikiReferencesModel, resources: Resources) : String{
        return when(lastWikiReferences.references)
        {
            0 -> resources.getString(R.string.last_search_no_result)
            else -> resources.getQuantityString(R.plurals.last_search_result,lastWikiReferences.references, lastWikiReferences.query, lastWikiReferences.references)
        }
    }
}