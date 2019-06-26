package eu.lecabinetnumerique.wikireferences.mainviewmodeltests


import com.google.common.truth.Truth
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel
import eu.lecabinetnumerique.wikireferences.presentation.mainviewmodel.MainViewModel_Impl
import eu.lecabinetnumerique.wikireferences.presentation.mainviewmodel.MainViewModel_Int
import eu.lecabinetnumerique.wikireferences.presentation.utils.ResourcesUtils
import eu.lecabinetnumerique.wikireferences.testutils.AndroidBaseTest
import eu.lecabinetnumerique.wikireferences.testutils.OnClickTests
import eu.lecabinetnumerique.wikireferences.usecases.UseCases_Fake
import org.junit.Before
import org.junit.Test

class mainViewModelTests_withFake : AndroidBaseTest() {

    // Model to test
    private lateinit var mainViewModel : MainViewModel_Int

    // dependencies
    private lateinit var useCases: UseCases_Fake

    // tests
    private lateinit var onClickTests: OnClickTests

    @Before
    fun setup() {
        useCases = UseCases_Fake()
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
        val wikiReferencesModel =  WikiReferencesModel("Liverpool",2019)
        useCases.nextQueryAmountOfReferences = wikiReferencesModel.references

        // Act and Assert
        onClickTests.onClick_success(wikiReferencesModel)
    }

    @Test
    fun onClick_error_in_research(){
        // Arrange
        useCases.setErrorModeON()

        // Act and Assert
        onClickTests.onClick_error_in_research()
    }
}