import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)

    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.dotech.erakulistest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.dotech.erakulistest"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    android.buildFeatures.buildConfig = true
    buildTypes {
        // Get the API key from local.properties
        val localProperties = Properties().apply {
            val localPropertiesFile = rootProject.file("local.properties")
            if (localPropertiesFile.exists()) {
                localPropertiesFile.inputStream().use { load(it) }
            }
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )


            buildConfigField("String", "API_URL", "\"${localProperties["apiUrl"]}\"")
            buildConfigField("String", "API_KEY", "${localProperties["apiKey"]}")
        }
        debug {
            buildConfigField("String", "API_URL", "${localProperties["apiUrl"]}")
            buildConfigField("String", "API_KEY", "${localProperties["apiKey"]}")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    hilt {
        enableAggregatingTask = false
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //Compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.lifecycle.viewmodel.compse)
    implementation(libs.androidx.navigation.compse)
    implementation(libs.com.google.accompanist.flowlayout)

    //Icons
    implementation(libs.androidx.material3.icons)
    implementation(libs.coil)

    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    //Coroutines
    implementation(libs.org.jetbrains.kotlinx.coroutine.core)
    implementation(libs.org.jetbrains.kotlinx.coroutine.android)


    //Coroutines Lifecycle Scoops
    implementation(libs.androidx.lifecyle.lifecyleViewmodel)
    implementation(libs.androidx.lifecycle.runtime.ktx)


    //Dagger Hilt
    implementation(libs.com.google.dagger.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose) //hiltViewModel
    ksp(libs.com.google.dagger.hilt.complier)
    ksp(libs.androidx.hilt.complier)



    //Retrofit2
    implementation(libs.com.squareup.retrofit2)
    implementation(libs.com.squareup.retrofit2.converter.gson)
    implementation(libs.com.squareup.retrofit2.converter.scalars)

    // OkHTTP3
    implementation(libs.com.squareup.okhttp3)
    implementation(libs.com.squareup.okhttp3.logging)
    implementation(libs.okhttp.profiler)

    //Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.complier)
    implementation(libs.androidx.room.ext)
    implementation(libs.bcrypt)

    //Swipe refresh layout
    implementation(libs.androidx.swiperefreshlayout)

    implementation(libs.androidx.paging.compose)


    //Test-UnitTesting
    testImplementation(libs.junit)
    //Test-Mockito
    testImplementation(libs.org.mockito.mockito.core)
    testImplementation(libs.org.mockito.mockito.inline)
    testImplementation(libs.com.nhaarman.mockitokotlin2)
    //Test-Coroutine
    testImplementation(libs.org.jetbrains.kotlinx.coroutine.test)
    //LiveDAtaAndroidViewModel
    testImplementation(libs.androidx.arch.core.testing)

    //UI Testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)


    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}