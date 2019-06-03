package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel

abstract class MainViewModel_Int : ViewModel() {
    abstract var editTextString : String
    abstract fun onSearchButtonClick()
    abstract val lastSearchString : LiveData<String>
    abstract val snackBarString : LiveData<String>
    abstract val searchState : LiveData<SearchStateModel>
}