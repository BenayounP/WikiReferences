package eu.lecabinetnumerique.tinywikicount.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.binder.MainViewModelUtils
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Impl
import eu.lecabinetnumerique.tinywikicount.usescases.MainUsesCases_Fake


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainViewModelUtils.bind(this,R.layout.activity_main, MainViewModel_Impl(MainUsesCases_Fake()));
    }
}
