package eu.lecabinetnumerique.wikireferences.testutils


import android.content.Context
import eu.lecabinetnumerique.wikireferences.framework.BuildConfig
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config


// AN abstract class that :
// * helps to define tests working with robotelectric
// * working on min sdk version
// * give access to context in JVM unit tests

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [BuildConfig.MIN_SDK_VERSION])
abstract class AndroidBaseTest {
    val context: Context by lazy {
        RuntimeEnvironment.application
    }
}