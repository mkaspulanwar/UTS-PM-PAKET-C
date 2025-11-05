package id.antasari.uts_mp_230104040212.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import id.antasari.uts_mp_230104040212.data.DataStoreManager
import id.antasari.uts_mp_230104040212.ui.screens.DashboardScreen
import id.antasari.uts_mp_230104040212.ui.screens.LoginScreen
import id.antasari.uts_mp_230104040212.ui.screens.SplashScreen

object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val DASHBOARD = "dashboard" // we'll use argument: dashboard/{username}
}

@Composable
fun AppNavHost(dataStoreManager: DataStoreManager) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            SplashScreen(
                dataStoreManager = dataStoreManager,
                onNavigateToLogin = { navController.navigate(Routes.LOGIN) },
                onNavigateToDashboard = { username ->
                    // pass username as argument
                    navController.navigate("${Routes.DASHBOARD}/${username}") {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                dataStoreManager = dataStoreManager,
                onLoginSuccess = { username ->
                    navController.navigate("${Routes.DASHBOARD}/${username}") {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = "${Routes.DASHBOARD}/{username}",
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: "User"
            DashboardScreen(
                username = username,
                dataStoreManager = dataStoreManager,
                onLogout = {
                    // navigate back to login and clear back stack
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.DASHBOARD) { inclusive = true }
                    }
                }
            )
        }
    }
}
