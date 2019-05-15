package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import eu.lecabinetnumerique.tinywikicount.BR.viewModel
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.databinding.ActivityMainBinding
import eu.lecabinetnumerique.tinywikicount.usescases.MainUsesCases_Fake


@BindingAdapter("android:hideIfEmpty")
fun hideIfEmpty(view: View, observableString : ObservableField<String>) {
    view.visibility = if (observableString?.get().isNullOrEmpty()) View.GONE else View.VISIBLE
}


object MainViewModelUtils {
    fun <T> bind(appCompatActivity: AppCompatActivity, viewLayoutId:Int, viewModel : T ) where T : ViewModel, T : MainViewModel_Int
    {
        val activityMainBinding =DataBindingUtil.setContentView<ActivityMainBinding>(appCompatActivity, viewLayoutId)
        activityMainBinding.viewModel = ViewModelProviders.of(
            appCompatActivity,
            viewModelFactory {viewModel}
        ).get(viewModel::class.java)
    }

    inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(aClass: Class<T>):T = f() as T
        }
}