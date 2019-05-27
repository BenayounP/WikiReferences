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
import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Int


@BindingAdapter("android:hideIfEmpty")
fun hideIfEmpty(view: View, liveString : LiveData<String>) {
    view.visibility = if (liveString.value.isNullOrEmpty()) View.GONE else View.VISIBLE
}

@BindingAdapter("android:hideIfLoading")
fun hideIfLoading(view: View, liveSearchState: LiveData<SearchStateModel>) {
    view.visibility = if (liveSearchState.value==SearchStateModel.Loading) View.GONE else View.VISIBLE
}

@BindingAdapter("android:showIfLoading")
fun showIfLoading(view: View, liveSearchState: LiveData<SearchStateModel>) {
    view.visibility = if (liveSearchState.value==SearchStateModel.Loading) View.VISIBLE else View.GONE
}


object MainViewModelUtils {
    fun bind(appCompatActivity: AppCompatActivity, viewLayoutId:Int, mainViewModel : MainViewModel_Int )
    {
        val activityMainBinding =DataBindingUtil.setContentView<ActivityMainBinding>(appCompatActivity, viewLayoutId)
        activityMainBinding.viewModel = ViewModelProviders.of(
            appCompatActivity,
            viewModelFactory { mainViewModel }
        ).get(mainViewModel::class.java)
        activityMainBinding.lifecycleOwner=appCompatActivity
    }

    private inline fun <viewModel : ViewModel> viewModelFactory(crossinline f: () -> viewModel) =
        object : ViewModelProvider.Factory {
            override fun <viewModel : ViewModel> create(aClass: Class<viewModel>):viewModel = f() as viewModel
        }
}