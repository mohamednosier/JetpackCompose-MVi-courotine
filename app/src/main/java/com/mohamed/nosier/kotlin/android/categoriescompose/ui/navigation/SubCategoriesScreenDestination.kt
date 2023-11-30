package com.mohamed.nosier.kotlin.android.categoriescompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories.SubCategoriesContract
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories.SubCategoriesViewModel
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories.composables.ReposScreen
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun ReposScreenDestination(categoryId: String, navController: NavController) {
    val viewModel = getViewModel<SubCategoriesViewModel> { parametersOf(categoryId) }
    ReposScreen(
        state = viewModel.viewState.value,
        effectFlow = viewModel.effect,
        onEventSent = { event -> viewModel.setEvent(event) },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is SubCategoriesContract.Effect.Navigation.Back) {
                navController.popBackStack()
            }
        },
    )
}
