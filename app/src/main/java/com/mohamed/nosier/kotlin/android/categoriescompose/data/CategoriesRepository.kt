package com.mohamed.nosier.kotlin.android.categoriescompose.data

import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.SubCategories
import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.Categories

interface CategoriesRepository {
    suspend fun getCategories(): Result<List<Categories>>
    suspend fun getSubCategories(categoryId: String): Result<List<SubCategories>>
}
