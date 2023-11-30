package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories.composables

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.base.SIDE_EFFECTS_KEY
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.common.NetworkError
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.common.Progress
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories.CategoriesContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun CategoriesScreen(
    state: CategoriesContract.State,
    effectFlow: Flow<CategoriesContract.Effect>?,
    onEventSent: (event: CategoriesContract.Event) -> Unit,
    onNavigationRequested: (navigationEffect: CategoriesContract.Effect.Navigation) -> Unit
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is CategoriesContract.Effect.DataWasLoaded -> {
                }
                is CategoriesContract.Effect.Navigation.ToSubCategories -> onNavigationRequested(effect)
            }
        }?.collect()
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { CategoriesTopBar() }
    ) {
        when {
            state.isLoading -> Progress()
            state.isError -> NetworkError { onEventSent(CategoriesContract.Event.Retry) }
            else -> CategoriesList(categories = state.categories) { onEventSent(CategoriesContract.Event.CategoriesSelection(it)) }
        }
    }
}
