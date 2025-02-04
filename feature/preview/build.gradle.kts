plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.google.jetpackcamera.feature.preview"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    // Compose
    val composeBom = platform("androidx.compose:compose-bom:2023.08.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Compose - Material Design 3
    implementation("androidx.compose.material3:material3")

    // Compose - Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Compose - Integration with ViewModels with Navigation and Hilt
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Compose - Testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    testImplementation("org.mockito:mockito-core:5.2.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6")

    // Guava
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:1.4.1")

    // CameraX
    val camerax_version = "1.3.0-SNAPSHOT"
    implementation("androidx.camera:camera-core:${camerax_version}")
    implementation("androidx.camera:camera-view:${camerax_version}")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-compiler:2.44")

    // Project dependencies
    implementation(project(":data:settings"))
    implementation(project(":domain:camera"))
    implementation(project(":camera-viewfinder-compose"))
    implementation(project(":feature:quicksettings"))
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}