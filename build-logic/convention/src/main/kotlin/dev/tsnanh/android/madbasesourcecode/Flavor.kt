@file:Suppress("UnstableApiUsage")

package dev.tsnanh.android.madbasesourcecode

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

enum class FlavorDimension {
    Mode
}

enum class Flavors(
    val dimension: FlavorDimension,
    val applicationSuffix: String? = null,
) {
    Dev(dimension = FlavorDimension.Mode, applicationSuffix = ".dev"),
    Prod(dimension = FlavorDimension.Mode),
}

fun Project.configureFlavors(
    commonExtension: CommonExtension<*, *, *, *>
) {
    commonExtension.apply {
        flavorDimensions += FlavorDimension.Mode.name

        productFlavors {
            Flavors.values().forEach { flavor ->
                create(flavor.name) {
                    dimension = flavor.dimension.name
                }
            }
        }
    }
}
