package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.framework.MainApplication

class MainViewModel_Fake() : MainViewModel_Int, ViewModel() {

    override var editTextString : String = ""
    override fun onCheckSearchCountButtonClick() {
        if (editTextString.isNotBlank()) {
            val fakeOccurrences = (1..1000).shuffled().first()
            _lastSearchString.value =MainApplication.applicationContext().resources.getQuantityString(R.plurals.last_search_result,fakeOccurrences, editTextString, fakeOccurrences)
        }
    }
    private val _lastSearchString = MutableLiveData<String>().apply{ value = "" }
    override val lastSearchString: LiveData<String> = _lastSearchString
}