package eu.lecabinetnumerique.wikireferences.presentation.mainviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eu.lecabinetnumerique.wikireferences.R
import eu.lecabinetnumerique.wikireferences.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.wikireferences.domain.wikireferences.WikiReferencesModel
import eu.lecabinetnumerique.wikireferences.framework.MainApplication
import eu.lecabinetnumerique.wikireferences.presentation.utils.ResourcesUtils
import eu.lecabinetnumerique.wikireferences.usecases.UseCases_Int

class MainViewModel_Impl(val useCases : UseCases_Int) : MainViewModel_Int()  {

    override var editTextString: String = ""

    private val _lastSearchString = MutableLiveData<String>()
    override val lastSearchString: LiveData<String> = _lastSearchString

    private val _snackBarString = MutableLiveData<String>().apply{ value = "" }
    override val snackBarString: LiveData<String> = _snackBarString

    private val _searchStateModel = MutableLiveData<SearchStateModel>()
    override val searchState: LiveData<SearchStateModel> = _searchStateModel


    init {
        useCases.getWikiReferencesObserver().onChange = { oldValue, newValue ->
            setLastSearch(newValue)}
        useCases.getSearchStateObserver().onChange ={
                oldValue, newValue -> setSearchState(newValue)}
        setLastSearch(useCases.getWikiReferencesObserver().currentWikiReferences)
    }

    override fun onSearchButtonClick() {
        if (editTextString.length!=0)
        {
            useCases.searchReferencesOnWiki(editTextString)
        }
        else {
            _snackBarString.value = MainApplication.applicationContext().getString(R.string.empty_query_error)
        }
    }


    private fun setLastSearch(newWikiReferencesModel: WikiReferencesModel){
        if (newWikiReferencesModel.isEmpty()==false) {
            _lastSearchString.value = ResourcesUtils.getSearchResultString(
                newWikiReferencesModel,
                MainApplication.applicationContext().resources)
        }
    }

    private fun setSearchState(newSearchStateModel: SearchStateModel) {
        _searchStateModel.value = newSearchStateModel
        when (_searchStateModel.value) {
            SearchStateModel.Error -> _snackBarString.value =
                MainApplication.applicationContext().getString(R.string.research_error)
            else -> _snackBarString.value = ""
        }
    }

}

