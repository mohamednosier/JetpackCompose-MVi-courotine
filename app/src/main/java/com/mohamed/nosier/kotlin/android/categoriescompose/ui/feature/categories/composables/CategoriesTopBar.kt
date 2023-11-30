package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories.composables

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mohamed.nosier.kotlin.android.categoriescompose.R

@Composable
fun CategoriesTopBar() {
//    TopAppBar(
//        title = { Text(text = stringResource(R.string.categories_screen_top_bar_title)) }
//    )
}

@Preview(showBackground = true)
@Composable
fun SubCategoriesTopBarPreview() {
    CategoriesTopBar()
}