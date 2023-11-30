package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories

import androidx.lifecycle.viewModelScope
import com.mohamed.nosier.kotlin.android.categoriescompose.data.CategoriesRepository
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SubCategoriesViewModel(
    private val id: String,
    private val categoriesRepository: CategoriesRepository
) : BaseViewModel<SubCategoriesContract.Event, SubCategoriesContract.State, SubCategoriesContract.Effect>() {

    init { getAll() }

    override fun setInitialState() = SubCategoriesContract.State(
        subCategoriesList = emptyList(),
        isCategoriesLoading = true,
        isSubCategoriesLoading = true,
        isError = false,
    )

    override fun handleEvents(event: SubCategoriesContract.Event) {
        when (event) {
            SubCategoriesContract.Event.BackButtonClicked -> {
                setEffect { SubCategoriesContract.Effect.Navigation.Back }
            }
            SubCategoriesContract.Event.Retry -> getAll()
        }
    }

    private fun getAll() {
        viewModelScope.launch {
            getSubCategories()
        }
    }

    private suspend fun getSubCategories() {
        setState { copy(isSubCategoriesLoading = true, isError = false) }

        categoriesRepository.getSubCategories(id)
            .onSuccess { subCategories ->
                setState { copy(subCategoriesList = subCategories, isSubCategoriesLoading = false) }
            }
            .onFailure {
                setState { copy(isError = true, isSubCategoriesLoading = false) }
            }
    }

}