object Versions {

    // ANDROIDX VERSIONS
    // https://developer.android.com/jetpack/androidx/versions


    /**
     * GLOBAL
     */

    // Build config
    val compileSdkVersion = 28
    val minSdkVersion = 16
    val targetSdkVersion = compileSdkVersion

    // App version
    const val appVersionCode = 1
    const val appVersionName = "0.9.0"

    // Kotlin
    val kotlin = "1.3.31"
    val ktx="1.0.2"
    val coroutines ="1.2.1"

    /**
     * TEST
     *
     * source :
     * https://developer.android.com/training/testing/set-up-project
     */

    // Core library
    val coreTest ="1.2.0"

    // AndroidJUnitRunner and JUnit Rules
    val jUnit= "1.1.0"


    // Assertions
    val assertions =  "1.0.0"

    // Espresso dependencies
    val espresso= "3.1.0"

    // mockito kotlin
    val mockitoKotlin = "2.1.0"

    // roboelectric
    // http://robolectric.org/getting-started/
    val robotelectric = "4.3"

    

    /**
     * PRESENTATION/FRAMEWORK
     */

    // Android
    val appCompat="1.0.2"
    val material = "1.0.0-rc01"
    val constraintLayout="1.1.3"
    val lifecycle ="2.0.0"
    val databinding_compiler ="3.4.0"

    /**
     * FRAMEWORK
     */

    // Retrofit
    val retrofit="2.4.0"

    // Rxandroid
    val rxandroid ="2.1.0"

    // Room
    val room = "2.1.0-alpha07"

}


object Dependencies {

    /**
     * GLOBAL
     */

    // Kotlin
    val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val ktx ="androidx.core:core-ktx:${Versions.ktx}"
    val coroutines_core ="org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutines_android ="org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // Android
    val appcompat ="androidx.appcompat:appcompat:${Versions.appCompat}"
    val material ="com.google.android.material:material:${Versions.material}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val kapt_databinding_compiler = "com.android.databinding:compiler:${Versions.databinding_compiler}"
    val lifecycle ="androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    /**
     * TEST
     */
    // Core library
    val coreTest ="androidx.test:core:${Versions.coreTest}"

    // junit for Kotlin
    val JUnitKotlin = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"

    // AndroidJUnitRunner and JUnit Rules
    val JUnitAndroidRunner= "androidx.test:runner:${Versions.jUnit}"
    val JUnitRules = "androidx.test:rules:${Versions.jUnit}"

    // Assertions
    val JUnitAssertions =  "androidx.test.ext:junit:${Versions.assertions}"
    val truthAssertions =  "androidx.test.ext:truth:${Versions.assertions}"

    // Espresso dependencies
    val espressoCore= "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val espressoContrib=  "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    val espressoIntents=  "androidx.test.espresso:espresso-intents:${Versions.espresso}"
    val espressoAccessibility =  "androidx.test.espresso:espresso-accessibility:${Versions.espresso}"
    val espressoWeb=  "androidx.test.espresso:espresso-web:${Versions.espresso}"
    val espressoConcurrent= "androidx.test.espresso.idling:idling-concurrent:${Versions.espresso}"

    // The following Espresso dependency can be either "implementation"
    // or "androidTestImplementation", depending on whether you want the
    // dependency to appear on your APK"s compile classpath or the test APK
    // classpath.
    val espressoIdlingResource= "androidx.test.espresso:espresso-idling-resource:${Versions.espresso}"

    // mockito
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"

    // robotelectric
    val robotelectric = "org.robolectric:robolectric:${Versions.robotelectric}"

    /**
     * FRAMEWORK
     */

    // Retrofit
    val retrofit_Main = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_RxJava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val retrofit_Gson_Converter="com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // Rxandroid
    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"

    // Room
    val kapt_room = "android.arch.persistence.room:compiler:${Versions.room}"
    val room = "androidx.room:room-runtime:${Versions.room}"
    val room_ktx_coroutines = "androidx.room:room-ktx:${Versions.room}"
}