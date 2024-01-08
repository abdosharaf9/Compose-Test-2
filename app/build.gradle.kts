import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
}

android {
    namespace = "com.abdosharaf.composetest2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.abdosharaf.composetest2"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        // load the values from .properties file
        val keystoreFile = project.rootProject.file("keys.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())

        // return empty key in case something goes wrong
        val apiKey = properties.getProperty("API_KEY") ?: ""
        buildConfigField("String", "API_KEY", apiKey)
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Coil to load images
    implementation("io.coil-kt:coil-compose:2.5.0")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.6")

    // System UI Controller - Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.27.0")

    // Pager and Indicators - Accompanist
    implementation("com.google.accompanist:accompanist-pager:0.24.2-alpha")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.24.2-alpha")

    // DataStore Preferences
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    kapt("androidx.hilt:hilt-compiler:1.1.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    // Splash API
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Swipeable Component
    implementation("me.saket.swipe:swipe:1.2.0")

    // Draw Box
    implementation("io.ak1:drawbox:1.0.3")

    // Permissions - Accompanist
    implementation("com.google.accompanist:accompanist-permissions:0.24.9-beta")

    // Material Icons Extended
//    implementation("androidx.compose.material:material-icons-extended:1.5.4")

    // WebView Accompanist
    implementation("com.google.accompanist:accompanist-webview:0.33.2-alpha")

    // Color Picker
    implementation("com.github.skydoves:colorpicker-compose:1.0.7")

    // Sheets & Dialogs
//    implementation("com.maxkepperler.sheets-compose-dialogs:core:1.0.2")
//    implementation("com.maxkepperler.sheets-compose-dialogs:calender:1.0.2")
//    implementation("com.maxkepperler.sheets-compose-dialogs:clock:1.0.2")

    // Lottie Animation
    implementation("com.airbnb.android:lottie-compose:6.3.0")

    // Downloadable Fonts
    implementation("androidx.compose.ui:ui-text-google-fonts:1.5.4")

    // Room Database
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-paging:2.6.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    // Kotlinx Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")

    // Paging 3
    implementation("androidx.paging:paging-compose:3.2.1")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}