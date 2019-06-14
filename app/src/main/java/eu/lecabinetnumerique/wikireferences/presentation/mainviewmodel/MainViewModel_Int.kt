package eu.lecabinetnumerique.wikireferences.presentation.mainviewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel

abstract class MainViewModel_Int : ViewModel() {

    // Represents query filled in editText by user
    // ex: "Liverpool"
    abstract var editTextString : String

    // This function is called when user click on research button
    abstract fun onSearchButtonClick()

    // A reactive data representing the last search user has made (it can come from data at launch or from network)
    // ex: "Liverpool: 60 284 references"
    abstract val lastSearchString : LiveData<String>

    // A reactive data representing the string displayed by snackbar in case of error
    // ex: "There was an error during research. Please try again later"
    abstract val snackBarString : LiveData<String>

    // A reactive data representing the search state of the app.
    // ex: "Searching" if app is currently searching for reference for "Liverpool"
    // see "SearchStateModel" for more details
    // see SearchStateModel class for more details
    abstract val searchState : LiveData<SearchStateModel>
}