object Versions {
    val kotlin = "1.3.31"
    val appCompat="1.0.2"
    val ktx="1.0.1"
    val constraintLayout="1.1.3"
    val lifecycle ="2.0.0"
    val databinding_compiler ="3.4.0"
}
object Dependencies {
    val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val appcompat ="androidx.appcompat:appcompat:${Versions.appCompat}"
    val ktx ="androidx.core:core-ktx:${Versions.ktx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    val kapt_databinding_compiler = "com.android.databinding:compiler:${Versions.databinding_compiler}"
    val lifecycle ="androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

}