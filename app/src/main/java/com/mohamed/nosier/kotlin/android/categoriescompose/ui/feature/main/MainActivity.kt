package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.navigation.AppNavigation
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.theme.CategoryComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CategoryComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AppNavigation()
                }
            }
        }
    }
}
