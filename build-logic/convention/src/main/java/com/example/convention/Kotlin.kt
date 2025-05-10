package com.example.convention

import com.android.build.api.dsl.CommonExtension
import org.apache.tools.ant.taskdefs.Java
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        compileSdk = libs.findVersion("projectCompileSdkVersion").get().toString().toInt()

        defaultConfig {
            minSdk = libs.findVersion("projectMinSdkVersion").get().toString().toInt()
        }

        compileOptions {
            isCoreLibraryDesugaringEnabled = true
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }

    configureKotlin()

    dependencies {
        "coreLibraryDesugaring"(libs.findLibrary("desugar.jdk.libs").get())
    }
}

//이전 방식
//private fun Project.configureKotlin() {
//   tasks.withType<KotlinCompile>().configureEach {
//        kotlinOptions {
//            jvmTarget = JavaVersion.VERSION_17.toString()
//        }
//   }
//}

internal fun Project.configureKotlinJvm() {
    extensions.configure<JavaPluginExtension>("java") {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    configureKotlin()
}

//현재 방식
//kotlinOptions는 Deprecated되어서 compilerOptions를 통해 설정 가능
private fun Project.configureKotlin() {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
}