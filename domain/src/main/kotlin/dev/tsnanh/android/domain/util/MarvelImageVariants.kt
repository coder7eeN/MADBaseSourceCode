package dev.tsnanh.android.domain.util

import dev.tsnanh.core.models.Image

sealed interface MarvelImageVariants {
    val value: String

    enum class Portrait(override val value: String) : MarvelImageVariants {
        Small("portrait_small"),
        Medium("portrait_medium"),
        XLarge("portrait_xlarge"),
        Fantastic("portrait_fantastic"),
        Uncanny("portrait_uncanny"),
        Incredible("portrait_incredible"),
    }

    enum class Standard(override val value: String) : MarvelImageVariants {
        Small("standard_small"),
        Medium("standard_medium"),
        Large("standard_large"),
        XLarge("standard_xlarge"),
        Fantastic("standard_fantastic"),
        Amazing("standard_amazing")
    }

    enum class Landscape(override val value: String) : MarvelImageVariants {
        Small("landscape_small"),
        Medium("landscape_medium"),
        Large("landscape_large"),
        XLarge("landscape_xlarge"),
        Amazing("landscape_amazing"),
        Incredible("landscape_incredible")
    }
}

fun Image.url(type: MarvelImageVariants) = "$path/${type.value}.$extension".also { println(it) }
