package eu.lecabinetnumerique.tinywikicount.presentation


import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4


import org.junit.Rule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    

}