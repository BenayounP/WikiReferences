package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eu.lecabinetnumerique.tinywikicount.R

class MainViewModel_Fake() : MainViewModel_Int() {


    override var editTextString : String = ""
    override fun onCheckSearchCountButtonClick() {
        if (editTextString.isNotBlank()) {
            val fakeOccurrences = (1..1000).shuffled().first()
            _lastSearchString.value =
                eu.lecabinetnumerique.tiniwikicount.framework.MainApplication.applicationContext().resources.getQuantityString(R.plurals.last_search_result,fakeOccurrences, editTextString, fakeOccurrences)
        }
    }
    private val _lastSearchString = MutableLiveData<String>().apply{ value = "" }
    override val lastSearchString: LiveData<String> = _lastSearchString
}