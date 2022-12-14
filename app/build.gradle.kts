@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.kotlin.kapt.get().pluginId)
    id(libs.plugins.kotlin.parcelize.get().pluginId)
    id(libs.plugins.hilt.plugin.get().pluginId)
    id(libs.plugins.google.plugin.get().pluginId)
}

android {
    namespace = "com.ddr.racingstory"
    compileSdk  = 32

    defaultConfig {
        applicationId = "com.ddr.racingstory"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    hilt {
        enableAggregatingTask = true
    }

    kotlin {
        sourceSets.configureEach {
            kotlin.srcDir("$buildDir/generated/ksp/$name/kotlin/")
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":core-model"))

    // androidx
    implementation(libs.material)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.startup)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintLayout)

    //lottie
    implementation(libs.lottie)


    // data binding
    implementation(libs.bindables)

    // di
    implementation(libs.hilt.android)
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    kapt(libs.hilt.compiler)
    androidTestImplementation(libs.hilt.testing)
    kaptAndroidTest(libs.hilt.compiler)

    //firebase
    implementation(libs.firebase.database.ktx)

    // coroutines
    implementation(libs.coroutines)

    // whatIf
    implementation(libs.whatif)

    // glide
    implementation(libs.glide)

    // bundler
    implementation(libs.bundler)

    // recyclerView
    implementation(libs.recyclerview)
    implementation(libs.baseAdapter)

    //analytics
    implementation(libs.firebase.analytics.ktx)

}