package dev.tsnanh.android.core.navigation.contracts

object NavigationRoute {
    const val USER = "user"
}

fun Map<String, NoResultActivityContract>.findContract(key: String): NoResultActivityContract {
    return this[key] ?: error("No destination route or contract not found!")
}
