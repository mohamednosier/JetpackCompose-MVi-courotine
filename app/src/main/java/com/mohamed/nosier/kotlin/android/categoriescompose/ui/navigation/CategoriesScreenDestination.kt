package com.mohamed.nosier.kotlin.android.categoriescompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories.CategoriesContract
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories.CategoriesViewModel
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories.composables.CategoriesScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun UsersScreenDestination(navController: NavController) {
    val viewModel = getViewModel<CategoriesViewModel>()
    CategoriesScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = { event ->  viewModel.setEvent(event) },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is CategoriesContract.Effect.Navigation.ToSubCategories) {
                navController.navigateToRepos(navigationEffect.categoriesId)
            }
        }
    )
}
