package com.mohamed.nosier.kotlin.android.categoriescompose.data

import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.SubCategories
import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.Categories
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CategoriesRepositoryTest {

    private val githubApi = mockk<TasksApi>()
    private val githubRepository: CategoriesRepository = CategoriesRepositoryImpl(githubApi)

    @Test
    fun `When getUsers called then should call getUsers from the API`() = runTest {
        // Given
        val users = listOf(Categories())
        coEvery { githubApi.getCategories() } returns users

        // When
        val result = githubRepository.getCategories()

        // Then
        assert(result.isSuccess)
        coVerify(exactly = 1) { githubApi.getCategories() }
        confirmVerified(githubApi)
    }


    @Test
    fun `When getRepos called then should call getRepos from the API`() = runTest {
        // Given
        val categoryId = "1"
        coEvery { githubApi.getSubCategories(categoryId) } returns listOf(SubCategories())

        // When
        val result = githubRepository.getSubCategories(categoryId)

        // Then
        assert(result.isSuccess)
        coVerify(exactly = 1) { githubApi.getSubCategories(categoryId) }
        confirmVerified(githubApi)
    }

    @Test
    fun `Given an exception When getUsers called then returns failure`() = runTest {
        // Given
        coEvery { githubApi.getCategories() } throws Exception("")

        // When
        val result = githubRepository.getCategories()

        // Then
        assert(result.isFailure)
    }

    @Test
    fun `Given an exception When getRepos called then returns failure`() = runTest {
        // Given
        coEvery { githubApi.getSubCategories(any()) } throws Exception("")

        // When
        val result = githubRepository.getSubCategories("1")

        // Then
        assert(result.isFailure)
    }
}