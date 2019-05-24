object Versions {
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

    // Android
    val appCompat="1.0.2"
    val constraintLayout="1.1.3"
    val lifecycle ="2.0.0"
    val databinding_compiler ="3.4.0"

    // Test
    val junit = "4.12"
    val mockito ="1.5.0"
    val robolectric ="4.2"

    // retrofit
    val retrofit="2.4.0"

    // rxandroid
    val rxandroid ="2.1.0"
}
object Dependencies {
    // Kotlin
    val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val ktx ="androidx.core:core-ktx:${Versions.ktx}"

    // Android
    val appcompat ="androidx.appcompat:appcompat:${Versions.appCompat}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val kapt_databinding_compiler = "com.android.databinding:compiler:${Versions.databinding_compiler}"
    val lifecycle ="androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    // Test
    val junit ="junit:junit:${Versions.junit}"
    val mockito = "com.nhaarman:mockito-kotlin-kt1.1:${Versions.mockito}"
    val roboelectric ="org.robolectric:robolectric:${Versions.robolectric}"

    // retrofit
    val retrofit_Main = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_RxJava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val retrofit_Gson_Converter="com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    //rxandroid
    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"

}