// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    // Use the Kotlin Android plugin correctly
    id("com.android.application") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false // Ensure the correct plugin ID
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2") // Android Gradle plugin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0") // Kotlin Gradle plugin
    }
}

// Configure repositories for all projects
allprojects {
    repositories {
        //google()
       // mavenCentral()
    }
}

// Define the Gradle properties for the project
tasks.register("clean") {
    delete(rootProject.buildDir)
}
