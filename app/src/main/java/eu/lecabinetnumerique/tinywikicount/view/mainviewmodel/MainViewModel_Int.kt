package eu.lecabinetnumerique.tinywikicount.view.mainviewmodel


import androidx.databinding.ObservableField

interface MainViewModel_Int {
    var editTextString : String

    fun onCheckSearchCountButtonClick()
    val lastSearch : ObservableField<String>
}