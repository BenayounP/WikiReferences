package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiReferencesModel
import eu.lecabinetnumerique.tinywikicount.presentation.ResourcesUtils
import eu.lecabinetnumerique.tinywikicount.usecases.UseCases_Int

class MainViewModel_Impl(val useCases : UseCases_Int) : MainViewModel_Int()  {

    override var editTextString: String = ""

    private val _lastSearchString = MutableLiveData<String>()
    override val lastSearchString: LiveData<String> = _lastSearchString

    private val _searchStateModel = MutableLiveData<SearchStateModel>()
    override val searchState: LiveData<SearchStateModel> = _searchStateModel


    init {
        useCases.getWikiCountObserver().onChange = { oldValue, newValue -> setLastSearch(newValue)}
        useCases.getSearchStateObserver().onChange ={ oldValue, newValue -> setSearchState(newValue)}
    }

    override fun onCheckSearchCountButtonClick() {
        useCases.searchOccurrencesOnWiki(editTextString)
    }



    private fun setLastSearch(newWikiReferencesModel: WikiReferencesModel){
        _lastSearchString.value = ResourcesUtils.getSearchResultString(newWikiReferencesModel,
            eu.lecabinetnumerique.tiniwikicount.framework.MainApplication.applicationContext().resources)
    }

    private fun setSearchState(newSearchStateModel: SearchStateModel){
        _searchStateModel.value = newSearchStateModel
    }
}


