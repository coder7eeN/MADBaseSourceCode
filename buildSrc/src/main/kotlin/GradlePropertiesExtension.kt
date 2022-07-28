import org.gradle.api.Project

const val COMPOSE_INTEROP = "dev.tsnanh.android.composeInterop"

val Project.isComposeInteropEnabled: Boolean
    get() = (properties[COMPOSE_INTEROP] as? Boolean) ?: false
