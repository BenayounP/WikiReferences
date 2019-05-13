package eu.lecabinetnumerique.tinywikicount.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.lecabinetnumerique.tinywikicount.R
import eu.lecabinetnumerique.tinywikicount.view.mainviewmodel.MainViewModelInjector
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainViewModelInjector.setViewModel(this,R.layout.activity_main)
    }
}
