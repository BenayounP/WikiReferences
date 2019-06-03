package eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.binder

import android.content.Context
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.databinding.ActivityMainBinding
import eu.lecabinetnumerique.tinywikicount.domain.searchstate.SearchStateModel
import eu.lecabinetnumerique.tinywikicount.presentation.mainviewmodel.MainViewModel_Int


@BindingAdapter("hideIfEmpty")
fun hideIfEmpty(view: View, liveString : LiveData<String>) {
    view.visibility = if (liveString.value.isNullOrEmpty()) View.GONE else View.VISIBLE
}

@BindingAdapter("hideIfLoading")
fun hideIfLoading(view: View, liveSearchState: LiveData<SearchStateModel>) {
    view.visibility = if (liveSearchState.value==SearchStateModel.Loading) View.GONE else View.VISIBLE
}

@BindingAdapter("showIfLoading")
fun showIfLoading(view: View, liveSearchState: LiveData<SearchStateModel>) {
    view.visibility = if (liveSearchState.value==SearchStateModel.Loading) View.VISIBLE else View.GONE
}

@BindingAdapter("displaySnackBar")
fun displaySnackBar(view : CoordinatorLayout, snackBarString : LiveData<String>){
    if (snackBarString.value.isNullOrEmpty()==false) Snackbar.make(view,snackBarString.value as CharSequence, Snackbar.LENGTH_LONG).show()
}

@BindingAdapter("setSearchButtonClickListener")
fun setSearchButtonClickListener(view: Button, mainViewModel: MainViewModel_Int) {
    view.setOnClickListener {
        // hide Keyboard
        (view.context.getSystemService(Context.INPUT_METHOD_SERVICE)
                as InputMethodManager).hideSoftInputFromWindow(view.windowToken, 0)
        mainViewModel.onSearchButtonClick()
    }


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