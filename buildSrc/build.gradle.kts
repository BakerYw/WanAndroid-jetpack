plugins {
    `kotlin-dsl`
}
repositories {
    google()
    mavenCentral()
    jcenter()
}
/**
 * 禁用关于使用实验性 Kotlin 编译器功能的警告
 */
kotlinDslPluginOptions.experimentalWarning.set(false)

/**
 *  isFork：将编译器作为单独的进程运行。
 *  该过程在构建期间将被重用，因此分叉开销很小。分叉的好处是，内存密集型编译是在不同的过程中进行的，从而导致主 Gradle 守护程序中的垃圾回收量大大减少。
 *  守护程序中较少的垃圾收集意味着 Gradle 的基础架构可以运行得更快，尤其是在您还使用的情况下 --parallel。
 *
 *  isIncremental：增量编译。Gradle 可以分析直至单个类级别的依赖关系，以便仅重新编译受更改影响的类。自 Gradle 4.10 起，增量编译是默认设置。
 */
tasks.withType<JavaCompile> {
    options.isFork = true
    options.isIncremental = true
}

/**
 * 禁用测试报告（Gradle 默认会自动创建测试报告）
 */
tasks.withType<Test> {
    reports.html.isEnabled = false
    reports.junitXml.isEnabled = false
}

object Plugins {
    const val AGP = "7.0.0"
    const val DOKKA = "1.5.0"
    const val KOTLIN = "1.5.20"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Plugins.KOTLIN}")
    implementation("com.android.tools.build:gradle:${Plugins.AGP}")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:${Plugins.DOKKA}")
    implementation("org.jetbrains.dokka:dokka-core:${Plugins.DOKKA}")
}