package dev.tsnanh.android.core.network.endpoints

/**
 * Retrofit annotation key prefixes:
 * p = Path
 * q = Query
 */
internal object Endpoint {
    object Characters {
        const val characters = "characters"
        object GET {
            const val qApiKey = "apikey"
            const val qTimestamp = "ts"
        }
    }

    object POST {

    }

    object PUT {

    }

    object PATCH {

    }

    object DELETE {

    }
}
