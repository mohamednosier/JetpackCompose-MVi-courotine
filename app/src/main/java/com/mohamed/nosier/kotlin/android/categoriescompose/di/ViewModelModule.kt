package com.mohamed.nosier.kotlin.android.categoriescompose.di

import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories.SubCategoriesViewModel
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories.CategoriesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CategoriesViewModel(CategoriesRepository = get())
    }

    viewModel { parameters ->
        SubCategoriesViewModel(
            id = parameters.get(),
            categoriesRepository = get()
        )
    }
}
