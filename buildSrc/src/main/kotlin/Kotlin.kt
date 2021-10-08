/**
 * @author com.nyw.libbase.launcher
 * @date 2021/9/16 2:40 下午
 * @introduction 协程等kotlin内部使用类
 */
@SuppressWarnings("SpellCheckingInspection")
object Kotlin {
    //Kotlin 1.4 以后，您不再需要在 gradle 上声明 stdlib
    var stdlib ="org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin_version}"
    val stdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin_version}"
    val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin_version}"
    val test = "org.jetbrains.kotlin:kotlin-test-junit:${Version.kotlin_version}"
    val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin_version}"
    //协程
    val coroutines = Coroutines
    object Coroutines{
        private const val version = "1.5.0"
        const val core ="org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android ="org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }
}