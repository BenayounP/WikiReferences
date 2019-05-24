package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

abstract class MainViewModel_Int : ViewModel() {
    abstract var editTextString : String
    abstract fun onCheckSearchCountButtonClick()
    abstract val lastSearchString : LiveData<String>

}