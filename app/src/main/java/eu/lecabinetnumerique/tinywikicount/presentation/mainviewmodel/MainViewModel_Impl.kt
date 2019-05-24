package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eu.lecabinetnumerique.tinywikicount.domain.wikicount.WikiCountModel
import eu.lecabinetnumerique.tinywikicount.presentation.ResourcesUtils
import eu.lecabinetnumerique.tinywikicount.usecases.UseCases_Int

class MainViewModel_Impl(val useCases : UseCases_Int) : MainViewModel_Int()  {

    override var editTextString: String = ""

    init {
        useCases.getWikiCountObserver().onChange = { oldValue, newValue -> setLastSearch(newValue) }
    }

    override fun onCheckSearchCountButtonClick() {
        useCases.searchOccurrencesOnWiki(editTextString)
    }

    private val _lastSearchString = MutableLiveData<String>()

    override val lastSearchString: LiveData<String> = _lastSearchString

    private fun setLastSearch(wikiCountModel: WikiCountModel){
        _lastSearchString.value = ResourcesUtils.getSearchResultString(wikiCountModel,
            eu.lecabinetnumerique.tiniwikicount.framework.MainApplication.applicationContext().resources)
    }

}

