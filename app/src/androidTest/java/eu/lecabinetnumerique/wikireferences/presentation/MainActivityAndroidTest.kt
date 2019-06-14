package eu.lecabinetnumerique.wikireferences.presentation


import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import eu.lecabinetnumerique.wikireferences.R
import eu.lecabinetnumerique.wikireferences.presentation.utils.DataBindingIdlingResourceRule
import eu.lecabinetnumerique.wikireferences.presentation.utils.robots.ScreenRobot
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityAndroidTest{

    val editText = R.id.edit_search;
    val progressBar = R.id.progress_circular
    val searchButton = R.id.btn_search
    val lastSearchTitle = R.id.txt_last_search_title
    val lastSearchContent = R.id.txt_last_search_content
    val snackBar = com.google.android.material.R.id.snackbar_text

    fun searchReferences(query: String) : ScreenRobot {
        return ScreenRobot.getInstance().enterTextIntoView(editText,query)
            .clickOkOnView(searchButton)
    }

    @get:Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Rule
    @JvmField
    val dataBindingIdlingResourceRule =
        DataBindingIdlingResourceRule(activityRule)


    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }


    @Test
    fun appLaunchesSuccessfully() {
        // Arrange, Act...and Assert!
       // nothing to do all is in the setup!
    }

    @Test
    fun displaySnackOnEmptyQuery() {
        // Arrange, Act
        searchReferences("")
            // Assert
            .checkIsDisplayed(snackBar)
    }

    @Test
    fun IdleButtonOnFetching() {
        // Arrange
        val query = "marseille"

        //Act
        searchReferences(query)
            // Assert
            .checkIsHidden(searchButton)
    }

    //  WARNING : Test do not pass, espresso do not wait for result

    @Test
    fun displayResultOnQuery() {
        // todo make it work!

        // There is a trick:
        // We make two researches to ensure that a previous saved research is not displayed in lastSearchContent even if there was a pb

        // Arrange
        val query1 = "Manchester"
        val query2 = "Liverpool"


        //Act
        searchReferences(query1)
            // Assert
            .checkViewContainsText(lastSearchContent,query1)

        searchReferences(query2)
            // Assert
            .checkViewContainsText(lastSearchContent,query2)
    }

}