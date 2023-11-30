package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories

import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.Categories
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.base.ViewEvent
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.base.ViewSideEffect
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.base.ViewState

class CategoriesContract {

    sealed class Event : ViewEvent {
        object Retry : Event()
        data class CategoriesSelection(val categories: Categories) : Event()
    }

    data class State(
        val categories: List<Categories>,
        val isLoading: Boolean,
        val isError: Boolean,
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        object DataWasLoaded : Effect()

        sealed class Navigation : Effect() {
            data class ToSubCategories(val categoriesId: String): Navigation()
        }
    }

}
