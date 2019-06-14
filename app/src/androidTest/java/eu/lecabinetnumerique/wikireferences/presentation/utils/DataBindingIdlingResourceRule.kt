package eu.lecabinetnumerique.wikireferences.presentation.utils


import androidx.test.espresso.IdlingRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * SOURCE :
 * https://github.com/googlesamples/android-architecture-components/blob/7f861fd45d158e6277a3c35163c7f663e135b2cf/GithubBrowserSample/app/src/androidTest/java/com/android/example/github/util/DataBindingIdlingResourceRule.kt
 * A JUnit rule that registers an idling resource for all fragment views that use data binding.
 */

class DataBindingIdlingResourceRule(
    activityTestRule: ActivityTestRule<*>
) : TestWatcher() {
    private val idlingResource =
        DataBindingIdlingResource(activityTestRule)

    override fun finished(description: Description?) {
        IdlingRegistry.getInstance().unregister(idlingResource)
        super.finished(description)
    }

    override fun starting(description: Description?) {
        IdlingRegistry.getInstance().register(idlingResource)
        super.starting(description)
    }

}