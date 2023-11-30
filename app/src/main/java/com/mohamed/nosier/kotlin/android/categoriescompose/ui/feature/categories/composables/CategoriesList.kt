package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.Categories

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoriesList(
    categories: List<Categories>,
    onItemClick: (Categories) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().padding(top=20.dp))
        {
            Text(
                text = stringResource(com.mohamed.nosier.kotlin.android.categoriescompose.R.string.categories_screen_top_bar_title),
                style = MaterialTheme.typography.subtitle2,)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().padding(top=20.dp))
        {
            Text(
                text = stringResource(com.mohamed.nosier.kotlin.android.categoriescompose.R.string.headline),
                style = MaterialTheme.typography.subtitle2,
                color= Color.DarkGray
                )
        }
        Box(
            modifier= Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
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
}
