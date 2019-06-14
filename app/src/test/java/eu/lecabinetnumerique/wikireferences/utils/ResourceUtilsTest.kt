package eu.lecabinetnumerique.wikireferences.utils

import com.google.common.truth.Truth
import eu.lecabinetnumerique.wikireferences.R
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel
import eu.lecabinetnumerique.wikireferences.presentation.utils.ResourcesUtils
import eu.lecabinetnumerique.wikireferences.testutils.AndroidBaseTest
import org.junit.Test


class ResourceUtilsTest : AndroidBaseTest() {

    lateinit var wikiReferencesModel : WikiReferencesModel

    @Test
    fun testResultStringWithOReferences()
    {
        // Arrange
        wikiReferencesModel = WikiReferencesModel("Manchester",0)

        //Act and Test
        Truth.assertThat(ResourcesUtils.getSearchResultString(wikiReferencesModel,context.resources))
            .isEqualTo(context.resources.getString(R.string.last_search_no_result))
    }

    @Test
    fun testResultStringWith1Reference()
    {
        // Arrange
        wikiReferencesModel = WikiReferencesModel("Manchester",1)

        //Act and Test
        Truth.assertThat(ResourcesUtils.getSearchResultString(wikiReferencesModel,context.resources))
            .isEqualTo(context.resources.getQuantityString(R.plurals.last_search_result,wikiReferencesModel.references, wikiReferencesModel.query, wikiReferencesModel.references))
    }

    @Test
    fun testResultStringWith1References()
    {
        // Arrange
        wikiReferencesModel = WikiReferencesModel("Manchester",1)

        //Act and Test
        Truth.assertThat(ResourcesUtils.getSearchResultString(wikiReferencesModel,context.resources))
            .isEqualTo(context.resources.getQuantityString(R.plurals.last_search_result,wikiReferencesModel.references, wikiReferencesModel.query, wikiReferencesModel.references))
    }

    @Test
    fun testResultStringWithManyReferences()
    {
        // Arrange
        wikiReferencesModel = WikiReferencesModel("Liverpool",2019)

        //Act and Test
        Truth.assertThat(ResourcesUtils.getSearchResultString(wikiReferencesModel,context.resources))
            .isEqualTo(context.resources.getQuantityString(R.plurals.last_search_result,wikiReferencesModel.references, wikiReferencesModel.query, wikiReferencesModel.references))
    }

}