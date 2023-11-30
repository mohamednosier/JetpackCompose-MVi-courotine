package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories

import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.SubCategories
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.base.ViewEvent
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.base.ViewSideEffect
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.base.ViewState

class SubCategoriesContract {

    sealed class Event : ViewEvent {
        object Retry : Event()
        object BackButtonClicked : Event()
    }

    data class State(
        val subCategoriesList: List<SubCategories>,
        val isCategoriesLoading: Boolean,
        val isSubCategoriesLoading: Boolean,
        val isError: Boolean,
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object Back : Navigation()
        }
    }

}
