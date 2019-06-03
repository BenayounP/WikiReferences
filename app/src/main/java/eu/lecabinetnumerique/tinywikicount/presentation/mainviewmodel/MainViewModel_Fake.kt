package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel

class MainViewModel_Fake() : MainViewModel_Int() {

    private val _lastSearchString = MutableLiveData<String>().apply{ value = "" }
    override val lastSearchString: LiveData<String> = _lastSearchString

    private val _snackBarString = MutableLiveData<String>().apply{ value = "" }
    override val snackBarString: LiveData<String> = _lastSearchString

    private val _searchStateModel = MutableLiveData<SearchStateModel>()
    override val searchState: LiveData<SearchStateModel> = _searchStateModel

    override var editTextString : String = ""
    override fun onSearchButtonClick() {
        if (editTextString.isNotBlank()) {
            val fakeReferences = (1..1000).shuffled().first()
            _lastSearchString.value =
                eu.lecabinetnumerique.tiniwikicount.framework.MainApplication.applicationContext().resources.getQuantityString(R.plurals.last_search_result,fakeReferences, editTextString, fakeReferences)
            _snackBarString.value =""
        }
        else {
            _snackBarString.value = eu.lecabinetnumerique.tiniwikicount.framework.MainApplication.applicationContext().getString(R.string.user_hasnt_fill_query)
        }
    }
}