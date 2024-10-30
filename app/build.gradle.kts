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
}
tasks.withType<Javadoc> {
    exclude("**/module-info.java")
    // Optional: exclude other Kotlin files if they're causing issues
    exclude("**/*.kt")
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(fileTree(mapOf("dir" to "C:\\Users\\Sithi\\AppData\\Local\\Android\\Sdk\\platforms\\android-34", "include" to listOf("*.aar", "*.jar"))))

    implementation(libs.support.annotations)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}