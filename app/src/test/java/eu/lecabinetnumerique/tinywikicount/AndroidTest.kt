package eu.lecabinetnumerique.tinywikicount


import android.content.Context
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [BuildConfig.MIN_SDK_VERSION])
abstract class AndroidTest {
    val context: Context by lazy {
        RuntimeEnvironment.application
    }
}