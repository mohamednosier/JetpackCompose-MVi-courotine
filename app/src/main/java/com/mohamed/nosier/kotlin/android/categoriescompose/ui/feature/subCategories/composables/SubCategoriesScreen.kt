package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories.composables

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.base.SIDE_EFFECTS_KEY
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.common.NetworkError
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.common.Progress
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories.SubCategoriesContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun ReposScreen(
    state: SubCategoriesContract.State,
    effectFlow: Flow<SubCategoriesContract.Effect>?,
    onEventSent: (event: SubCategoriesContract.Event) -> Unit,
    onNavigationRequested: (SubCategoriesContract.Effect.Navigation) -> Unit
) {

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                SubCategoriesContract.Effect.Navigation.Back -> {
                    onNavigationRequested(SubCategoriesContract.Effect.Navigation.Back)
                }
            }
        }?.collect()
    }

    Scaffold(
        topBar = { ReposTopBar {
            onEventSent(SubCategoriesContract.Event.BackButtonClicked)
        } }
    ) {
        when {
             state.isSubCategoriesLoading -> Progress()
            state.isError -> NetworkError { onEventSent(SubCategoriesContract.Event.Retry) }
            else -> {
                    SubCategoriesList(

                        subCategoriesList = state.subCategoriesList
                    )
                }
            }
        }
    }
