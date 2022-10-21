import org.gradle.api.Project

private const val ComposeEnabled = "dev.tsnanh.android.composeEnabled"

val Project.isComposeEnabled: Boolean
    get() = (properties[ComposeEnabled] as? Boolean) ?: false
