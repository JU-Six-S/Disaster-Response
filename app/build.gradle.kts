plugins {
    alias(libs.plugins.android.application)
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
    }
    buildToolsVersion = "34.0.0"
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(fileTree(mapOf(
        "dir" to "C:\\Users\\nasri\\AppData\\Local\\Android\\Sdk\\platforms\\android-34",
        "include" to listOf("*.aar", "*.jar"),
        //"exclude" to listOf()
    )))

    // JUnit 5 for unit testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")

    // Mockito for mocking
    testImplementation("org.mockito:mockito-core:3.11.2")
    testImplementation("org.mockito:mockito-junit-jupiter:3.11.2")

    // LiveData testing (optional, useful for ViewModel testing)
    testImplementation("androidx.arch.core:core-testing:2.1.0")

    // Robolectric for Android environment in unit tests
    testImplementation("org.robolectric:robolectric:4.7.3")

    // Android Testing libraries
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

// Ensuring JUnit 5 is used for platform tests
tasks.withType<Test> {
    useJUnitPlatform()

}


