package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories

import androidx.lifecycle.viewModelScope
import com.mohamed.nosier.kotlin.android.categoriescompose.data.CategoriesRepository
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val CategoriesRepository: CategoriesRepository
) : BaseViewModel<CategoriesContract.Event, CategoriesContract.State, CategoriesContract.Effect>() {

    init { getCategories() }

    override fun setInitialState() = CategoriesContract.State(
        categories = emptyList(),
        isLoading = true,
        isError = false,
    )

    override fun handleEvents(event: CategoriesContract.Event) {
        when (event) {
            is CategoriesContract.Event.CategoriesSelection -> setEffect { CategoriesContract.Effect.Navigation.ToSubCategories(
                event.categories.id.toString()
            ) }
            is CategoriesContract.Event.Retry -> getCategories()
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            setState { copy(isLoading = true, isError = false) }

            CategoriesRepository.getCategories()
                .onSuccess { categories ->
                    setState { copy(categories = categories, isLoading = false) }
                    setEffect { CategoriesContract.Effect.DataWasLoaded }
                }
                .onFailure {
                    setState { copy(isError = true, isLoading = false) }
                }
        }
    }
}
