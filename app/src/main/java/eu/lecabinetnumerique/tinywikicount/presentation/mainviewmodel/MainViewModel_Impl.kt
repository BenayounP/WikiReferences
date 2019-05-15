package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.framework.MainApplication
import eu.lecabinetnumerique.tinywikicount.usescases.MainUsesCases_Int

class MainViewModel_Impl(val mainUsesCases_Int : MainUsesCases_Int) : MainViewModel_Int, ViewModel()  {
    override var editTextString: String = ""

    override fun onCheckSearchCountButtonClick() {
        val occurrences : Int = mainUsesCases_Int.getOccurrences(editTextString)
        lastSearchString.set(MainApplication.applicationContext().resources.getQuantityString(R.plurals.last_search_result,occurrences, editTextString, occurrences))
    }

    override val lastSearchString: ObservableField<String> = ObservableField<String>(mainUsesCases_Int.getLastSearch())
}
