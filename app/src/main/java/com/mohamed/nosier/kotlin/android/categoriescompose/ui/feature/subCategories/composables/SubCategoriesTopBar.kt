package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mohamed.nosier.kotlin.android.categoriescompose.R

@Composable
fun ReposTopBar(onBackButtonClicked: () -> Unit) {
//    TopAppBar(
//        title = { Text(text = stringResource(R.string.subCategories_screen_top_bar_title)) },
//        navigationIcon = {
//            IconButton(onClick = { onBackButtonClicked() }) {
//                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
//            }
//        }
//    )
}

@Preview(showBackground = true)
@Composable
fun ReposTopBarPreview() {
    ReposTopBar {}
}