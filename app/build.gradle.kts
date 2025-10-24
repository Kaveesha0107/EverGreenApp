plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.yourapp" // Replace with your app's namespace
    compileSdk = 40 // Or a higher API level if available and desired

    defaultConfig {
        applicationId = "com.example.yourapp" // Replace with your app's application ID
        minSdk = 40 // Or your desired minimum SDK
        targetSdk = 34 // You might want to update this too, but compileSdk is the direct fix
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    }

    buildTypes {
        release {
            isMinifyEnabled = false // Set to true for production releases to shrink your app
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
        // Example: Enable ViewBinding
        // viewBinding = true
        // Example: Enable Compose (if you are using Jetpack Compose)
        // compose = true
    }

    // Corrected packagingOptions block
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}") // Common exclusion for license files
            // Add your specific exclusion if needed:
            // excludes.add("META-INF/some_library_specific_file.xml")
        }
    }

    // If you are using Jetpack Compose, you might have a composeOptions block here
    // composeOptions {
    //    kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    // }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material) // For Material Design components
    implementation(libs.androidx.activity) // For Activity components (ensure you have the -ktx version if available and preferred)
    implementation(libs.androidx.constraintlayout) // For ConstraintLayout
implementation("androidx.fragment:fragment-ktx:1.7.1")
    // Add other necessary dependencies based on your project's needs
    // e.g., Lifecycle, ViewModel, LiveData, Navigation, Room, Retrofit, etc.
    // implementation(libs.androidx.lifecycle.runtime.ktx)
    // implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // implementation(libs.androidx.navigation.fragment.ktx)
    // implementation(libs.androidx.navigation.ui.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
