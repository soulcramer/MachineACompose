import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val kotlin_version by extra("1.4.10")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Libraries.androidGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        allWarningsAsErrors = true
        freeCompilerArgs = listOf(
            "-Xopt-in=kotlin.RequiresOptIn",
            "-Xallow-jvm-ir-dependencies",
            "-Xskip-prerelease-check",

            // Enable experimental coroutines APIs, including Flow
            "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-Xopt-in=kotlinx.coroutines.FlowPreview",
            "-Xopt-in=kotlin.Experimental"
        )

        // Set JVM target to 1.8
        jvmTarget = "1.8"
    }
}
