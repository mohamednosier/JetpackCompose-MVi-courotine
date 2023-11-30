package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories

import androidx.compose.runtime.snapshots.Snapshot
import com.mohamed.nosier.kotlin.android.categoriescompose.MainCoroutineRule
import com.mohamed.nosier.kotlin.android.categoriescompose.data.CategoriesRepository
import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.Categories
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@DelicateCoroutinesApi
@OptIn(ExperimentalCoroutinesApi::class)
class CategoriesViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val githubRepository = mockk<CategoriesRepository>()

    @Test
    fun `When view model initialized then should emit initial view state first`() = runTest {
        // Given
        val expectedInitialViewState = CategoriesContract.State(
            categories = emptyList(),
            isLoading = true,
            isError = false
        )

        // When
        val viewModel = CategoriesViewModel(githubRepository)

        // Then
        assertEquals(expectedInitialViewState, viewModel.viewState.value)
    }

    @Test
    fun `When getCategories called then should emit a view state`() = runTest {
        // Given
        val categoriesrs = listOf(Categories(id = 1))
        val expectedViewState = CategoriesContract.State(
            categories = categoriesrs,
            isLoading = false,
            isError = false
        )
        coEvery { githubRepository.getCategories() } returns Result.success(categoriesrs)

        // When
        val viewModel = CategoriesViewModel(githubRepository)

        // Then
        assertEquals(expectedViewState, viewModel.viewState.value)
    }

    @Test
    fun `When `() = runTest {

        // Given
        val categories = listOf(Categories(id = 1))
        val expectedViewState = CategoriesContract.State(
            categories = categories,
            isLoading = false,
            isError = false
        )
        coEvery { githubRepository.getCategories() } returns Result.success(categories)

        // When
        val snapshot = Snapshot.takeMutableSnapshot(
//            readObserver = {
//                println(it)
//            },
            writeObserver = {
                println(it)
            }
        )

        snapshot.enter {
            val viewModel = CategoriesViewModel(githubRepository)

            // Then
            assertEquals(expectedViewState, viewModel.viewState.value)
        }

        snapshot.apply()
    }

}