package dev.tsnanh.android.madbasesourcecode.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.tsnanh.android.feature.dashboard.dashboard
import dev.tsnanh.android.feature.dashboard.navigation.DashboardDestination

@Composable
fun MADNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DashboardDestination.route,
    ) {
        dashboard()
    }
}
