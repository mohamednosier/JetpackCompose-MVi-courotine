package com.mohamed.nosier.kotlin.android.categoriescompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.navigation.Navigation.Args.CATEGORY_ID

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.Routes.CATEGORIES
    ) {
        composable(
            route = Navigation.Routes.CATEGORIES
        ) {
            UsersScreenDestination(navController)
        }

        composable(
            route = Navigation.Routes.SUBCATEGORIES,
            arguments = listOf(navArgument(name = CATEGORY_ID) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val categoryId = requireNotNull(backStackEntry.arguments?.getString(CATEGORY_ID)) { "Category id is required as an argument" }
            ReposScreenDestination(
                categoryId = categoryId,
                navController = navController
            )
        }
    }
}

object Navigation {

    object Args {
        const val CATEGORY_ID = "user_id"
    }

    object Routes {
        const val CATEGORIES = "users"
        const val SUBCATEGORIES = "$CATEGORIES/{$CATEGORY_ID}"
    }

}

fun NavController.navigateToRepos(categoryId: String) {
    navigate(route = "${Navigation.Routes.CATEGORIES}/$categoryId")
}
