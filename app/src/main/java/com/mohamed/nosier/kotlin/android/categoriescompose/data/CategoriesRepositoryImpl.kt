package com.mohamed.nosier.kotlin.android.categoriescompose.data

import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.SubCategories
import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.Categories
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoriesRepositoryImpl(
    private val tasksapi: TasksApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
): CategoriesRepository {

    override suspend fun getCategories(): Result<List<Categories>> = makeApiCall(dispatcher) {
        tasksapi.getCategories()
    }

    override suspend fun getSubCategories(categoryId: String): Result<List<SubCategories>> = makeApiCall(dispatcher) {
        tasksapi.getSubCategories(categoryId)
    }

}

suspend fun <T> makeApiCall(
    dispatcher: CoroutineDispatcher,
    call: suspend () -> T
): Result<T> = runCatching {
    withContext(dispatcher) {
        call.invoke()
    }
}
