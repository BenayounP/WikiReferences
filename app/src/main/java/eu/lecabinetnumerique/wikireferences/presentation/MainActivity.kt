package eu.lecabinetnumerique.wikireferences.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.lecabinetnumerique.wikireferences.R
import eu.lecabinetnumerique.wikireferences.data.Data_Impl
import eu.lecabinetnumerique.wikireferences.data.Data_Int
import eu.lecabinetnumerique.wikireferences.data.local.LocalRepository_Int
import eu.lecabinetnumerique.wikireferences.data.network.WikiAPIMngr_Int
import eu.lecabinetnumerique.wikireferences.framework.MainApplication
import eu.lecabinetnumerique.wikireferences.framework.network.WikiAPIMngr_Impl
import eu.lecabinetnumerique.wikireferences.framework.roomlocalrepository.room.repository.RoomLocalRepository_Impl
import eu.lecabinetnumerique.wikireferences.presentation.mainviewmodel.MainViewModel_Impl
import eu.lecabinetnumerique.wikireferences.presentation.mainviewmodel.MainViewModel_Int
import eu.lecabinetnumerique.wikireferences.presentation.mainviewmodel.binder.MainViewVewModelBinderMngr
import eu.lecabinetnumerique.wikireferences.usecases.UseCases_Impl
import eu.lecabinetnumerique.wikireferences.usecases.UseCases_Int


class MainActivity : AppCompatActivity() {
    lateinit var localRepository : LocalRepository_Int
    lateinit var wikiAPIMngr : WikiAPIMngr_Int
    lateinit var data : Data_Int
    lateinit var useCases : UseCases_Int
    lateinit var mainViewModel : MainViewModel_Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setModules()
        MainViewVewModelBinderMngr.bind(this,R.layout.activity_main, mainViewModel)
    }

    private fun setModules()
    {
        localRepository =
            RoomLocalRepository_Impl()
        wikiAPIMngr = WikiAPIMngr_Impl()
        data = Data_Impl(wikiAPIMngr, localRepository)
        useCases = UseCases_Impl(data)
        mainViewModel = MainViewModel_Impl(useCases)
    }
}