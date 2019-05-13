package eu.lecabinetnumerique.tinywikicount.view

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField

@BindingAdapter("android:hideIfEmpty")
fun hideIfEmpty(view: View, observableString : ObservableField<String>) {
    view.visibility = if (observableString?.get().isNullOrEmpty()) View.GONE else View.VISIBLE
}