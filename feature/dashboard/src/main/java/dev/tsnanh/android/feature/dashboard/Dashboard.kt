package dev.tsnanh.android.feature.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.tsnanh.android.feature.dashboard.navigation.DashboardDestination

fun NavGraphBuilder.dashboard() {
    composable(route = DashboardDestination.route) {
        Dashboard()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Dashboard() {
    Scaffold { padding ->
        Text(text = "Hello World", modifier = Modifier.padding(padding))
    }
}
