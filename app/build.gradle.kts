plugins {
    id("com.android.application") // Android application plugin
    id("org.jetbrains.kotlin.android") // Kotlin Android plugin
}

android {
    namespace = "com.jusixs.ndrs"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jusixs.ndrs"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        compileOptions.isCoreLibraryDesugaringEnabled = true // Ensure core library desugaring is enabled
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Core dependencies
    implementation("androidx.appcompat:appcompat:1.6.1") // Update to latest version
    implementation("com.google.android.material:material:1.8.0") // Update to latest version
    implementation("androidx.activity:activity-ktx:1.7.2") // Update to latest version
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation(fileTree(mapOf(
//        "dir" to "C:\\Users\\ROWTECH\\AppData\\Local\\Android\\Sdk\\platforms\\android-34",
//        "include" to listOf("*.aar", "*.jar"),
//      //  "exclude" to listOf()
//    )))


    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:5.4.0") // Update to latest version
    testImplementation("androidx.arch.core:core-testing:2.1.0")  // For LiveData testin
    testImplementation ("org.robolectric:robolectric:4.9.1") // For testing Android components
    testImplementation ("androidx.recyclerview:recyclerview:1.2.1")

    androidTestImplementation("androidx.test.ext:junit:1.1.5") // Update to latest version
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // Update to latest version

    // Add desugaring library
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.2.3") // Consider updating to latest version if needed
}
