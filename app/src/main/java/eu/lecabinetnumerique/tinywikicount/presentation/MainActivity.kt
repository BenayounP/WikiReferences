package eu.lecabinetnumerique.tinywikicount.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.databinding.ActivityMainBinding
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Fake
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Impl
import eu.lecabinetnumerique.tinywikicount.usescases.MainUsesCases_Fake




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding =DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(
            this,
            viewModelFactory {MainViewModel_Impl(MainUsesCases_Fake()) }
        ).get(MainViewModel_Impl::class.java)

    }

    protected inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(aClass: Class<T>):T = f() as T
        }
}
