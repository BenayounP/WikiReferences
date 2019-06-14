package eu.lecabinetnumerique.wikireferences.usecases

import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel

/**
 * This class represents the use case layer in clean architecture
 *
 * It links user interaction from Presentation layer and the data from Data layer
 *
 * Given the simplicity of this application, this class reproduces the same methods as the Data class
  */

interface UseCases_Int {

    // see Data_Int for more details
    fun searchReferencesOnWiki(queryString: String)
    fun getWikiReferencesObserver(): WikiReferencesModel.Observer
    fun getSearchStateObserver(): SearchStateModel.Observer
}