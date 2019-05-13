package eu.lecabinetnumerique.tinywikicount.view.mainviewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.edit_search

class MainViewModel_Fake() : MainViewModel_Int, ViewModel() {

    override var editTextString : String = ""
    override fun onCheckSearchCountButtonClick() {

        lastSearch.set("$editTextString: 372")
    }

    override val lastSearch: ObservableField<String> = ObservableField<String>("")
}