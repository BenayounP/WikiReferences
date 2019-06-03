package eu.lecabinetnumerique.tinywikicount.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.lecabinetnumerique.tiniwikicount.framework.network.WikiAPIMngr_Impl
import eu.lecabinetnumerique.tiniwikicount.framework.roomlocalrepository.RoomLocalRepository_Impl
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.data.Repository_Impl
import eu.lecabinetnumerique.tinywikicount.data.Repository_Int
import eu.lecabinetnumerique.tinywikicount.data.local.LocalRepository_Fake
import eu.lecabinetnumerique.tinywikicount.data.local.LocalRepository_Int
import eu.lecabinetnumerique.tinywikicount.data.network.WikiAPIMngr_Int
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Impl
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Int
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.binder.MainViewModelUtils
import eu.lecabinetnumerique.tinywikicount.usecases.UseCases_Impl
import eu.lecabinetnumerique.tinywikicount.usecases.UseCases_Int
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var localRepository : LocalRepository_Int
    lateinit var wikiAPIMngr : WikiAPIMngr_Int
    lateinit var repository : Repository_Int
    lateinit var useCases : UseCases_Int
    lateinit var mainViewModel : MainViewModel_Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setModules()
        MainViewModelUtils.bind(this,R.layout.activity_main, mainViewModel)
    }

    private fun setModules()
    {
        localRepository = RoomLocalRepository_Impl()
        wikiAPIMngr = WikiAPIMngr_Impl()
        repository = Repository_Impl(wikiAPIMngr, localRepository)
        useCases = UseCases_Impl(repository)
        mainViewModel = MainViewModel_Impl(useCases)
    }
}