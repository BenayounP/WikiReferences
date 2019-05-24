package eu.lecabinetnumerique.tinywikicount


import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel
import eu.lecabinetnumerique.tinywikicount.presentation.ResourcesUtils
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Impl
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Int
import eu.lecabinetnumerique.tinywikicount.usecases.UseCases_Int
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class mainviewmodel_tests : AndroidTest() {

    // View WikiAPIJSonModel to Test
    private lateinit var mainViewModel : MainViewModel_Int

    // dependencies
    private lateinit var useCases: UseCases_Int

    // last search
    private lateinit var initialLastWikiCount : WikiCountModel

    @Before
    fun setup() {
        useCases = mock()
        initialLastWikiCount = WikiCountModel("Liverpool", 2019)
        whenever(useCases.getLastSavedSearch()).thenReturn(initialLastWikiCount)
        mainViewModel = MainViewModel_Impl(useCases)
    }

    @Test
    fun onFirstClick_display_rightMessage_atLaunch() {
        // Arrange
        val expectedResult = ResourcesUtils.getSearchResultString(initialLastWikiCount, context.resources)

        //assert
        Assert.assertEquals(expectedResult,mainViewModel.lastSearchString.value)
    }

    @Test
    fun onFirstClick_display_rightMessage_when_0_count() {
        // Arrange
        val occurrence = 0
        val query = "Manchester"

        onFirstClick_display_rightMessage(occurrence,query)

    }

    @Test
    fun onFirstClick_display_rightMessage_when_1_count() {
        // Arrange
        val occurrence = 1
        val query = "Manchester City"

        onFirstClick_display_rightMessage(occurrence,query)

    }

    @Test
    fun onFirstClick_display_rightMessage_when_multiple_counts() {
        // Arrange
        val occurrence = 2019
        val query = "Liverpool"

        onFirstClick_display_rightMessage(occurrence,query)

    }

    private fun onFirstClick_display_rightMessage(occurrences : Int, query : String){

        // arrange
        val search = WikiCountModel(query, occurrences)
        val expectedResult = ResourcesUtils.getSearchResultString(search, context.resources)

        // act
        whenever(useCases.searchOccurrencesOnWiki(any())).thenReturn(occurrences)
        mainViewModel.editTextString = query
        mainViewModel.onCheckSearchCountButtonClick()

        //assert
        Assert.assertEquals(expectedResult,mainViewModel.lastSearchString.value)
    }



}