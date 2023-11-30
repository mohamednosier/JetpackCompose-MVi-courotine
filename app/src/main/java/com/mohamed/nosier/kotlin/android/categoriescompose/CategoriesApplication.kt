package com.mohamed.nosier.kotlin.android.categoriescompose

import android.app.Application
import com.mohamed.nosier.kotlin.android.categoriescompose.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CategoriesApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@CategoriesApplication)
            modules(appModules)
        }
    }

}
