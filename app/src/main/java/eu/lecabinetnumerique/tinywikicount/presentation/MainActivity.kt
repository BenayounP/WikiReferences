package eu.lecabinetnumerique.tinywikicount.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.lecabinetnumerique.tiniwikicount.framework.network.WikiAPIMngr_Impl
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.data.Repository_Impl
import eu.lecabinetnumerique.tinywikicount.data.Repository_Int
import eu.lecabinetnumerique.tinywikicount.data.network.WikiAPIMngr_Fake
import eu.lecabinetnumerique.tinywikicount.data.network.WikiAPIMngr_Int
import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Impl
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Int
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.binder.MainViewModelUtils
import eu.lecabinetnumerique.tinywikicount.usecases.UseCases_Impl
import eu.lecabinetnumerique.tinywikicount.usecases.UseCases_Int


class MainActivity : AppCompatActivity() {
    val wikiAPIMngr : WikiAPIMngr_Int = WikiAPIMngr_Impl()
    val repository : Repository_Int = Repository_Impl(wikiAPIMngr)
    val _useCases : UseCases_Int = UseCases_Impl(repository)
    val mainViewModel : MainViewModel_Int = MainViewModel_Impl(_useCases)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainViewModelUtils.bind(this,R.layout.activity_main, mainViewModel)
    }
}