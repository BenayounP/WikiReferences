package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel


import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

interface MainViewModel_Int {
    var editTextString : String

    fun onCheckSearchCountButtonClick()
    val lastSearchString : LiveData<String>
}