package eu.lecabinetnumerique.wikireferences.mainviewmodeltests


import com.google.common.truth.Truth
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel
import eu.lecabinetnumerique.wikireferences.presentation.mainviewmodel.MainViewModel_Impl
import eu.lecabinetnumerique.wikireferences.presentation.mainviewmodel.MainViewModel_Int
import eu.lecabinetnumerique.wikireferences.presentation.utils.ResourcesUtils
import eu.lecabinetnumerique.wikireferences.testutils.AndroidBaseTest
import eu.lecabinetnumerique.wikireferences.testutils.OnClickTests
import eu.lecabinetnumerique.wikireferences.usecases.UseCases_Int
import org.junit.Before
import org.junit.Test

class mainViewModelTests_withMock : AndroidBaseTest() {

    // Model to test
    private lateinit var mainViewModel : MainViewModel_Int

    // dependencies
    private lateinit var useCases: UseCases_Int

    // for mocking
    private lateinit var wikiReferencesModelObservable: WikiReferencesModel.Observable
    private lateinit var wikiReferencesModelObserver: WikiReferencesModel.Observer
    private lateinit var searchStateModelObservable: SearchStateModel.Observable
    private lateinit var searchStateModelObserver: SearchStateModel.Observer

    // tests
    private lateinit var onClickTests: OnClickTests

    @Before
    fun setup() {
        // mock setup
        useCases = mock()
        wikiReferencesModelObservable = WikiReferencesModel.Observable()
        wikiReferencesModelObserver = wikiReferencesModelObservable.getObserver()

        searchStateModelObservable = SearchStateModel.Observable()
        searchStateModelObserver = searchStateModelObservable.getObserver()
        whenever(useCases.getWikiReferencesObserver()).thenReturn(wikiReferencesModelObserver)
        whenever(useCases.getSearchStateObserver()).thenReturn(searchStateModelObserver)

        // end of setup
        mainViewModel = MainViewModel_Impl(useCases)
        onClickTests = OnClickTests(mainViewModel)
    }

    // Initialisation
    @Test
    fun wikiReferencesAreLoadedAtInit(){

        // Arrange
        val expectedResults = ResourcesUtils.getSearchResultString(useCases.getWikiReferencesObserver().currentWikiReferences,context.resources);

        // Act
        // Nothing to do, mainViewModel is initialised at startup

        //Assert
        Truth.assertThat(mainViewModel.lastSearchString.value)
            .isEqualTo(expectedResults)
    }


    // Click management
    @Test
    fun onClick_error_with_empty_EditString(){
        // Arrange, Act and Assert
        onClickTests.onClick_error_with_empty_EditString()
    }

    @Test
    fun onClick_success(){
        // Arrange
        val query = "Liverpool"
        val searchWikiReferencesModel =  WikiReferencesModel(query,2019)
        whenever(useCases.searchReferencesOnWiki(query)).then {
            setWikiReferencesObservableValue(searchWikiReferencesModel)}

        // Act and Assert
        onClickTests.onClick_success(searchWikiReferencesModel)
    }

    @Test
    fun onClick_error_in_research(){
        // Arrange
        whenever(useCases.searchReferencesOnWiki(any())).then {
            setErrorState()}

        // Act and Assert
        onClickTests.onClick_error_in_research()
    }

    fun setWikiReferencesObservableValue(wikiReferencesModel: WikiReferencesModel){
        wikiReferencesModelObservable.wikiReferencesModel = wikiReferencesModel
    }

    fun setErrorState(){
        searchStateModelObservable.searchState = SearchStateModel.Error
    }
}