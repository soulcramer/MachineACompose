plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}

kapt {
    useBuildCache = true
    correctErrorTypes = true
    mapDiagnosticLocations = true // Show original Kotlin file rather than the generated one in errors
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId = "app.soulcramer.machineacompose"
        versionName = "1.0"

        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        resConfigs("en", "fr")

        vectorDrawables.useSupportLibrary = true
    }

//    signingConfigs {
//        getByName("debug") {
//            storeFile = rootProject.file("debug.keystore")
//            keyAlias = "androiddebugkey"
//            keyPassword = "android"
//            storePassword = "android"
//        }
//        create("release") {
//            storeFile = file("${System.getenv("HOME")}/cert/conf-companion.keystore")
//            storePassword = System.getenv("BITRISEIO_ANDROID_KEYSTORE_PASSWORD")
//            keyAlias = System.getenv("BITRISEIO_ANDROID_KEYSTORE_ALIAS")
//            keyPassword = System.getenv("BITRISEIO_ANDROID_KEYSTORE_PRIVATE_KEY_PASSWORD")
//        }
//    }

    packagingOptions {
        // Exclude AndroidX version files
        exclude("META-INF/*.version")
        // Exclude the Firebase/Fabric/other random properties files
        exclude("/*.properties")
        exclude("fabric/*.properties")
        exclude("META-INF/*.properties")
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "dbflow-rules.pro",
                    "glide-rules.pro",
                    "moshi-rules.pro",
                    "okhttp-rules.pro",
                    "proguard-rules.pro",
                    "retrofit-rules.pro",
                    "support-rules.pro",
                    "rx-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        isCoreLibraryDesugaringEnabled = true
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerVersion = Libraries.kotlinVersion
        kotlinCompilerExtensionVersion = Libraries.commposeVersion
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
}

dependencies {
    coreLibraryDesugaring(Libraries.jdkDesugar)

    implementation(project(":data"))

    implementation(Kotlin.stdlib.jdk8)
    implementation(KotlinX.coroutines.android)

    implementation(AndroidX.appCompat)
    implementation(AndroidX.core.ktx)
    implementation(AndroidX.lifecycle.viewModelKtx)
    implementation(AndroidX.lifecycle.liveDataKtx)
    implementation(AndroidX.navigation.fragmentKtx)
    implementation(AndroidX.navigation.uiKtx)
    implementation(Google.android.material)

    implementation(AndroidX.compose.foundation)
    implementation(AndroidX.compose.foundation.layout)
    implementation(AndroidX.compose.material)
    implementation(AndroidX.compose.material.icons.extended)
    implementation(AndroidX.compose.runtime)
    implementation(AndroidX.compose.runtime.liveData)
    implementation(AndroidX.ui.tooling)

    implementation(Libraries.store)

}
