package dev.tsnanh.android.core.navigation

import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest

fun NavController.navigate(deepLink: String, action: String? = null, mimeType: String? = null) {
    require(deepLink.startsWith(prefix = DeepLinkDestination.APP_SCHEME_AND_HOST)) {
        "Invalid deeplink"
    }
    val navDeepLinkRequest = NavDeepLinkRequest.Builder.fromUri(deepLink.toUri()).apply {
        if (action != null) setAction(action)
        if (mimeType != null) setMimeType(mimeType)
    }.build()
    this.navigate(navDeepLinkRequest)
}

interface DeepLinkDestination {
    val deepLink: String

    fun getNavDeepLinkRequest(vararg args: Pair<String, Any?> = arrayOf()): NavDeepLinkRequest {
        val regex = "[{.*?}]".toRegex()
        check(args.isNotEmpty() || deepLink.contains(regex))/* {
            "Missing argument or missing argument declaration"
        }*/
        val link = if (args.isEmpty()) deepLink.removeSuffix("/").substringBeforeLast("/") else deepLink
        val link1 = args.fold(link) { acc, (key, value) ->
            if (value == null) {
                return@fold acc.replace("{$key}", "")
            }
            return@fold acc.replace("{$key}", value.toString())
        }
        return NavDeepLinkRequest.Builder.fromUri(link1.toUri()).build()
    }

    companion object {
        const val APP_SCHEME_AND_HOST = "madbasesource://dev.tsnanh.android.madbasesource"
    }
}
