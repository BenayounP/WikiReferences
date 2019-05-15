package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.framework.MainApplication

class MainViewModel_Fake() : MainViewModel_Int, ViewModel() {

    override var editTextString : String = ""
    override fun onCheckSearchCountButtonClick() {
        if (editTextString.isNotBlank()) {
            val fakeOccurrences = (1..1000).shuffled().first()
            lastSearchString.set(MainApplication.applicationContext().resources.getQuantityString(R.plurals.last_search_result,fakeOccurrences, editTextString, fakeOccurrences))
        }
    }

    override val lastSearchString: ObservableField<String> = ObservableField<String>("")
}