import org.gradle.api.Project

private const val EnableCompose = "dev.tsnanh.android.enableCompose"

val Project.isComposeEnabled: Boolean
    get() = (properties[EnableCompose] as? Boolean) ?: false
