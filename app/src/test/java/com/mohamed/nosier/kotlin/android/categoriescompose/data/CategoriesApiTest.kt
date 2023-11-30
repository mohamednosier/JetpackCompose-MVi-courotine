package com.mohamed.nosier.kotlin.android.categoriescompose.data

import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.SubCategories
import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.Categories
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals

class CategoriesApiTest {

    private val mockWebService = MockWebServer()

    private val client = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS)
        .build()

    private val api = Retrofit.Builder()
        .baseUrl(mockWebService.url("/"))
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(TasksApi::class.java)

    @After
    fun tearDown() {
        mockWebService.shutdown()
    }

    @Test
    fun `Given 200 response When fetching users Then returns users correctly`() {
        // Given
        mockWebService.enqueueResponse(
            fileName = "categories.json",
            code = 200
        )
        val expected = listOf(
            Categories(
                id = 1,
                image = "https://avatars.githubusercontent.com/myofficework000",
                title = "https://github.com/myofficework000",
            ),
            Categories(
                id = 2,
                image = "https://avatars.githubusercontent.com/u/2?v=4",
                title = "https://github.com/defunkt",
            ),
            Categories(
                id = 3,
                image = "https://avatars.githubusercontent.com/u/3?v=4",
                title = "https://github.com/pjhyett",
            ),
        )

        // When
        val actual = runBlocking { api.getCategories() }
        val request = mockWebService.takeRequest()

        // Then
        assertEquals(expected, actual)
        assertEquals("/users", request.path)
    }



    @Test
    fun `Given 200 response When fetching repos Then returns repos correctly`() {
        // Given
        val userId = "mojombo"
        mockWebService.enqueueResponse(
            fileName = "subCategories.json",
            code = 200
        )

        val expected = listOf(
            SubCategories(
                id = 26899533,
                title = "30daysoflaptops.github.io",
                minBudget = 7,
                maxBudget = 2,
                avgBudget = 7
            ),
            SubCategories(
                id = 17358646,
                title = "asteroids",
                minBudget = 93,
                maxBudget = 13,
                avgBudget = 93
            ),
            SubCategories(
                id = 29941343,
                title = "benbalter.github.com",
                minBudget = 5,
                maxBudget = 7,
                avgBudget = 5

            ),
        )

        // When
        val actual = runBlocking { api.getSubCategories(userId) }
        val request = mockWebService.takeRequest()

        // Then
        assertEquals(expected, actual)
        assertEquals("/users/$userId/repos", request.path)
    }
}