package com.mohamed.nosier.kotlin.android.categoriescompose.di

import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories.SubCategoriesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.test.check.checkModules

class AppModuleTest {

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `verify koin app`() {
        koinApplication {
            modules(appModule, repositoryModule, viewModelModule)
            checkModules {
                withParameter<SubCategoriesViewModel> { "userId" }
            }
        }
    }
}