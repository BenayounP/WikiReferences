package eu.lecabinetnumerique.wikireferences.testutils

import com.google.common.truth.Truth
import eu.lecabinetnumerique.wikireferences.R
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel
import eu.lecabinetnumerique.wikireferences.presentation.mainviewmodel.MainViewModel_Int
import eu.lecabinetnumerique.wikireferences.presentation.utils.ResourcesUtils


// DISCLAIMER:
// This class could be avoided but I wanted a test class with parameters in the constructor
// NOT USABLE AS IS ! INCLUDE IT IN A TEST
class OnClickTests(var mainViewModel: MainViewModel_Int) : AndroidBaseTest() {

    fun onClick_error_with_empty_EditString(){
        // Arrange
        val expectedSnackBarErrorString = context.resources.getString(R.string.empty_query_error)

        // Act
        mainViewModel.editTextString = ""
        mainViewModel.onSearchButtonClick()

        //Assert
        Truth.assertThat(mainViewModel.snackBarString.value)
            .isEqualTo(expectedSnackBarErrorString)
    }

    fun onClick_success(expectedSuccessedResearch: WikiReferencesModel){
        // Arrange
        val expectedResultString = ResourcesUtils.getSearchResultString(expectedSuccessedResearch, context.resources)

        // Act
        mainViewModel.editTextString = expectedSuccessedResearch.query
        mainViewModel.onSearchButtonClick()

        //Assert
        Truth.assertThat(mainViewModel.lastSearchString.value)
            .isEqualTo(expectedResultString)
    }

    fun onClick_error_in_research(){
        // Arrange
        val expectedSnackBarErrorString = context.resources.getString(R.string.research_error)

        // Act
        mainViewModel.editTextString = "Any research"
        mainViewModel.onSearchButtonClick()

        //Assert
        Truth.assertThat(mainViewModel.snackBarString.value)
            .isEqualTo(expectedSnackBarErrorString)
    }


}