package com.mohamed.nosier.kotlin.android.categoriescompose.di

import com.mohamed.nosier.kotlin.android.categoriescompose.data.TasksApi
import com.mohamed.nosier.kotlin.android.categoriescompose.data.Endpoints
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        OkHttpClient.Builder().build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(TasksApi::class.java)
    }

}

val appModules = listOf(
    appModule,
    repositoryModule,
    viewModelModule
)
