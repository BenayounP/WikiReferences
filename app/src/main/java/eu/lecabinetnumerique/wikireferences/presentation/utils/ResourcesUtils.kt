package eu.lecabinetnumerique.wikireferences.presentation.utils

import android.content.res.Resources
import eu.lecabinetnumerique.wikireferences.R
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel

object ResourcesUtils {

    fun getSearchResultString(wikiReferences : WikiReferencesModel, resources: Resources) : String{
        return when(wikiReferences.references)
        {
            //Trick for 0 reference : resources.getQuantityString do not manage 0 quantity properly
            0 -> resources.getString(R.string.last_search_no_result)
            else -> resources.getQuantityString(R.plurals.last_search_result,wikiReferences.references, wikiReferences.query, wikiReferences.references)
        }
    }
}