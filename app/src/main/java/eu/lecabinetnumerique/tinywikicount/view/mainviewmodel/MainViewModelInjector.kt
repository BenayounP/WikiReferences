package eu.lecabinetnumerique.tinywikicount.view.mainviewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import eu.lecabinetnumerique.tinywikicount.databinding.ActivityMainBinding

object MainViewModelInjector {

    fun setViewModel(appCompatActivity: AppCompatActivity, viewLayoutId:Int)
    {
        val activityMainBinding =  DataBindingUtil.setContentView<ActivityMainBinding>(appCompatActivity, viewLayoutId)
        activityMainBinding.viewModel = ViewModelProviders.of(appCompatActivity).get(MainViewModel_Fake::class.java)
    }

}