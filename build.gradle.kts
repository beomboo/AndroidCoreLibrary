// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
}

buildscript{
    // AGP 버전 8.3.0으로 변경 (안정화 버전)
    dependencies{
        classpath("com.android.tools.build:gradle:8.3.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}