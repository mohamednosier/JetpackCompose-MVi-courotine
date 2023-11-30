package com.mohamed.nosier.kotlin.android.categoriescompose.di

import com.mohamed.nosier.kotlin.android.categoriescompose.data.CategoriesRepository
import com.mohamed.nosier.kotlin.android.categoriescompose.data.CategoriesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<CategoriesRepository> {
        CategoriesRepositoryImpl(
            tasksapi = get()
        )
    }

}