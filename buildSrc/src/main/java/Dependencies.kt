@file:Suppress("PublicApiImplicitType")

object Modules {
    const val app = ":app"

    const val core = ":core"
    const val remote = ":remote"

    const val cache = ":cache"

    const val data = ":data"
    const val domain = ":domain"
}
//
//object Versions {
//
//    object AndroidX {
//        const val activity = "1.1.0-beta01"
//        const val core = "1.2.0-beta01"
//        const val constraint_layout = "2.0.0-beta2"
//        const val swipeRefreshLayout = "1.1.0-alpha03"
//        const val fragment = "1.2.0-beta02"
//        const val emoji = "1.0.0"
//        const val lifecycle = "2.2.0-beta01"
//        const val paging = "2.1.0"
//        const val material = "1.1.0-beta01"
//        const val navigation = "2.2.0-beta01"
//        const val recyclerview = "1.1.0-beta05"
//        const val room = "2.2.0"
//    }
//
//    const val android_gradle = "4.1.0-alpha04"
//    const val benManes = "0.27.0"
//    const val buildScan = "2.4.2"
//    const val coroutines = "1.3.2"
//    const val detekt = "1.1.1"
//    const val epoxy = "3.8.0"
//    const val glide = "4.10.0"
//    const val koin = "2.1.0-alpha-1"
//    const val kotlin = "1.3.50"
//    const val ktlint = "0.35.0"
//    const val ktlintGradle = "9.0.0"
//    const val leakcanary = "2.0-beta-3"
//    const val moshi = "1.9.0-SNAPSHOT"
//    const val okhttp = "4.2.2"
//    const val photoview = "2.1.3"
//    const val retrofit = "2.6.2"
//    const val timberkt = "1.5.1"
//    const val threetenabp = "1.2.0"
//    const val threetenbp = "1.4.0"
//
//    object Test {
//        // Core library
//        const val core = "1.2.1-alpha02"
//
//        // AndroidJUnitRunner and JUnit Rules
//        const val runner = "1.3.0-alpha02"
//        const val rules = "1.1.2-alpha02"
//
//        const val jacoco = "0.8.5"
//
//        // Assertions
//        const val junitKtx = "1.1.2-alpha02"
//        const val truthKtx = "1.3.0-alpha02"
//        const val truth = "1.0"
//
//        // Espresso dependencies
//        const val espresso = "3.3.0-alpha02"
//
//        const val robolectric = "4.3.1"
//        const val mockk = "1.9.3"
//    }
//}

object Libraries {

//    object AndroidX {
//        const val activity = "androidx.activity:activity-ktx:_"
//        const val constraintLayout = "androidx.constraintlayout:constraintlayout:_"
//        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:_"
//        const val core = "androidx.core:core-ktx:_"
//        const val emoji = "androidx.emoji:emoji:_"
//        const val fragment = "androidx.fragment:fragment-ktx:_"
//        const val lifecycle = "androidx.lifecycle:lifecycle-extensions:_"
//        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:_"
//        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:_"
//        const val materialComponent = "com.google.android.material:material:_"
//        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:_"
//        const val navigationUi = "androidx.navigation:navigation-ui-ktx:_"
//        const val paging = "androidx.paging:paging-runtime-ktx:_"
//        const val recyclerView = "androidx.recyclerview:recyclerview:_"
//        const val room = "androidx.room:room-ktx:_"
//        const val roomRuntime = "androidx.room:room-runtime:_"
//        const val roomCompiler = "androidx.room:room-compiler:_"
//    }
//
//    const val epoxy = "com.airbnb.android:epoxy:_"
//    const val epoxyProcessor = "com.airbnb.android:epoxy-processor:_"
//    const val epoxyDataBinding = "com.airbnb.android:epoxy-databinding:_"
//    const val epoxyPaging = "com.airbnb.android:epoxy-paging:_"
//
//    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:_"
//    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:_"
//    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:_"
//
//    // DI
//    const val koin = "org.koin:koin-core:_"
//    const val koinAndroid = "org.koin:koin-android:_"
//    const val koinAndroidXScope = "org.koin:koin-androidx-scope:_"
//    const val koinViewModel = "org.koin:koin-androidx-viewmodel:_"
//
//    // Leak Canary
//    const val leackCanary = "com.squareup.leakcanary:leakcanary-android:_"
//
//    const val moshi = "com.squareup.moshi:moshi:_"
//    const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:_"
//    const val retrofit = "com.squareup.retrofit2:retrofit:_"
//    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:_"
//    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:_"
//
//    const val glide = "com.github.bumptech.glide:glide:_"
//    const val glideAnnotation = "com.github.bumptech.glide:annotations:_"
//    const val glideCompiler = "com.github.bumptech.glide:compiler:_"
//
//    const val store = "com.dropbox.mobile.store:store4:_"
//
//    const val glideOkhttp = "com.github.bumptech.glide:okhttp3-integration:_"
//    const val timberKt = "com.github.ajalt:timberkt:_"
    const val androidGradlePlugin = "com.android.tools.build:gradle:4.2.0-alpha12"
    const val jdkDesugar = "com.android.tools:desugar_jdk_libs:_"
    const val kotlinVersion = "1.4.10"
    const val commposeVersion = "1.0.0-alpha03"

//    object Test {
//        // Core library
//        const val core = "androidx.test:core:_"
//        const val fragment = "androidx.fragment:fragment-testing:_"
//
//        // AndroidJUnitRunner and JUnit Rules
//        const val runner = "androidx.test:runner:_"
//        const val rules = "androidx.test:rules:_"
//        const val room = "androidx.room:room-testing:_"
//
//        // Assertions
//        const val junitKtx = "androidx.test.ext:junit:_"
//        const val truthKtx = "androidx.test.ext:truth:_"
//        const val truth = "com.google.truth:truth:_"
//
//        // Espresso dependencies
//        const val espressoCore = "androidx.test.espresso:espresso-core:_"
//        const val espressoContrib = "androidx.test.espresso:espresso-contrib:_"
//        const val espressoIntents = "androidx.test.espresso:espresso-intents:_"
//        const val espressoAccessibility = "androidx.test.espresso:espresso-accessibility:_"
//        const val espressoWeb = "androidx.test.espresso:espresso-web:_"
//        const val espressoIdlingConcurent = "androidx.test.espresso.idling:idling-concurrent:_"
//
//        // The following Espresso dependency can be either "implementation"
//        // or "androidTestImplementation", depending on whether you want the
//        // dependency to appear on your APK's compile classpath or the test APK
//        // classpath.
//        const val espressoIdlingRes = "androidx.test.espresso:espresso-idling-resource:_"
//
//        const val robolectric = "org.robolectric:robolectric:_"
//        const val robolectricAnnotations = "org.robolectric:annotations:_"
//
//        const val mockk = "io.mockk:mockk:_"
//        const val mockkInstrumented = "io.mockk:mockk-android:_"
//
//        const val koin = "org.koin:koin-test:_"
//    }
}

object BuildConfigs {
    const val compileSdk = 29
    const val minSdk = 26
    const val targetSdk = 29
}