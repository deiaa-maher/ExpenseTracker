plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //id("kotlin-kapt")  // Add this line
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")  // ✅ Add KSP plugin
}

android {
    namespace = "com.deiaamaher.expensetracker"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.deiaamaher.expensetracker"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
}

    dependencies {
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)

        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)



    // Firebase
    implementation(libs.firebase.auth.ktx)  // Use version from `libs.versions.toml`
    implementation(libs.firebase.firestore.ktx) // Firestore support

    // Room Database
    implementation(libs.room.runtime)  // ✅ Uses version from catalog
    //ksp(libs.room.compiler)
    ksp(libs.room.ksp)  // ✅ Replaces kapt with KSP

    // Apache POI for Excel Export
    implementation(libs.poi.ooxml)

    // Coroutine Support
    implementation(libs.kotlinx.coroutines)
}

