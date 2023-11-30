package com.mohamed.nosier.kotlin.android.categoriescompose.data

import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.SubCategories
import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.Categories
import retrofit2.http.GET
import retrofit2.http.Path

interface TasksApi {
    @GET(Endpoints.GET_Categories)
    suspend fun getCategories(): List<Categories>

    @GET(Endpoints.GET_SubCategories_BY_Categories)
    suspend fun getSubCategories(@Path("id") id: String): List<SubCategories>
}
