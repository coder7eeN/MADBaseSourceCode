/*
 * Created by tsnanh on 6/4/22, 9:05 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 9:05 PM
 */

@file:Suppress("UnstableApiUsage")

import com.android.build.gradle.LibraryExtension
import dev.tsnanh.android.madbasesourcecode.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig {
                    testInstrumentationRunner =
                        "dev.tsnanh.android.madbasesourcecode.MADBaseSourceCodeTestRunner"
                }
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", project(":base"))
                add("implementation", project(":base-android"))
                add("implementation", project(":core:models"))
                add("implementation", project(":core:ui"))
                add("implementation", project(":domain"))
                add("implementation", project(":core:common"))
                add("implementation", project(":core:navigation"))

                add("testImplementation", project(":core:testing"))
                add("androidTestImplementation", project(":core:testing"))

                add("implementation", libs.findLibrary("coil.kt").get())

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())

                add("implementation", libs.findLibrary("hilt.android").get())
                add("kapt", libs.findLibrary("hilt.compiler").get())
                add("implementation", libs.findLibrary("androidx.appcompat").get())
                add("implementation", libs.findLibrary("androidx.fragment").get())
                add("implementation", libs.findLibrary("androidx.activity").get())
                add("implementation", libs.findLibrary("material3").get())
            }
        }
    }
}
