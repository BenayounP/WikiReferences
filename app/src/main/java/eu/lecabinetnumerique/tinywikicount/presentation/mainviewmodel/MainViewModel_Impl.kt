package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel

import androidx.lifecycle.*
import eu.lecabinetnumerique.tinywikicount.domain.SearchModel
import eu.lecabinetnumerique.tinywikicount.framework.MainApplication
import eu.lecabinetnumerique.tinywikicount.framework.ResourcesUtils
import eu.lecabinetnumerique.tinywikicount.usescases.MainUsesCases_Int

class MainViewModel_Impl(val mainUsesCases : MainUsesCases_Int) : MainViewModel_Int, ViewModel()  {
    override var editTextString: String = ""

    override fun onCheckSearchCountButtonClick() {
        val occurrences : Int = mainUsesCases.getOccurrences(editTextString)
        val search = SearchModel(editTextString,occurrences)
        _lastSearchString.value =ResourcesUtils.getSearchResultString(search,MainApplication.applicationContext().resources)

    }

    private val _lastSearchString = MutableLiveData<String>().apply{
        val lastSearch = mainUsesCases.getLastSearch()
        value = ResourcesUtils.getSearchResultString(lastSearch,MainApplication.applicationContext().resources) }
    override val lastSearchString: LiveData<String> = _lastSearchString
}

