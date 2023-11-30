package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.Categories

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoriesList(
    categories: List<Categories>,
    onItemClick: (Categories) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().background(Color.LightGray)) {

            LazyVerticalGrid(
                modifier = Modifier
                    .padding(10.dp),
                cells = GridCells.Adaptive(minSize = 200.dp),

            ) {

                items(categories) { categories ->
                    CategoriesListItem(categories = categories, onItemClick = onItemClick)
                }
            }
        }

}
