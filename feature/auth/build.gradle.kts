import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    // Target declarations - add or remove as needed below. These define
    // which platforms this KMP module supports.
    // See: https://kotlinlang.org/docs/multiplatform-discover-project.html#targets
    androidLibrary {
        namespace = "com.nutrisport.auth"
        compileSdk = 35
        minSdk = 24

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    // For iOS targets, this is also where you should
    // configure native binary output. For more information, see:
    // https://kotlinlang.org/docs/multiplatform-build-native-binaries.html#build-xcframeworks

    // A step-by-step guide on how to include this library in an XCode
    // project can be found here:
    // https://developer.android.com/kotlin/multiplatform/migrate
    val xcfName = "authKit"

    val xcFramework = XCFramework()

    iosX64 {
        binaries.framework {
            baseName = xcfName
            xcFramework.add(this)
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
            xcFramework.add(this)
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
            xcFramework.add(this)
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                // Add KMP dependencies here
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtimeCompose)
                implementation(libs.navigation.compose)
                implementation(libs.auth.kmp)
                implementation(libs.auth.firebase.kmp)
                implementation(project(path = ":shared"))
            }
        }
        androidMain {
            dependencies {
                implementation("com.google.firebase:firebase-auth-ktx:23.2.1")
                implementation("io.github.mirzemehdi:kmpauth-firebase:2.3.1") {
                    exclude(group = "com.google.firebase", module = "firebase-common-ktx")
                }
            }
        }
    }

}