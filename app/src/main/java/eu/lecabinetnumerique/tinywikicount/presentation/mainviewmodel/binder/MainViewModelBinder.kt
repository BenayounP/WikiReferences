package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.binder

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import eu.lecabinetnumerique.tinywikicount.databinding.ActivityMainBinding
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Int


@BindingAdapter("android:hideIfEmpty")
fun hideIfEmpty(view: View, observableString : LiveData<String>) {
    view.visibility = if (observableString?.value.isNullOrEmpty()) View.GONE else View.VISIBLE
}


object MainViewModelUtils {
    fun <T> bind(appCompatActivity: AppCompatActivity, viewLayoutId:Int, viewModel : T ) where T : ViewModel, T : MainViewModel_Int
    {
        val activityMainBinding =DataBindingUtil.setContentView<ActivityMainBinding>(appCompatActivity, viewLayoutId)
        activityMainBinding.viewModel = ViewModelProviders.of(
            appCompatActivity,
            viewModelFactory { viewModel }
        ).get(viewModel::class.java)
        activityMainBinding.lifecycleOwner=appCompatActivity
    }

    private inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(aClass: Class<T>):T = f() as T
        }
}