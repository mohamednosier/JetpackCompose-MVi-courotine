package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohamed.nosier.kotlin.android.categoriescompose.R
import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.SubCategories

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SubCategoriesList(
    subCategoriesList: List<SubCategories>
) {
    var sum=0
    subCategoriesList.forEach {
sum=it.avgBudget+sum
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
        {
            Text(
                text = stringResource(R.string.categories_screen_top_bar_title),
                style = MaterialTheme.typography.subtitle2,
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
        {
            Text(
                text = stringResource(R.string.headline),
                style = MaterialTheme.typography.subtitle2,
                color = Color.DarkGray
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )

        {
            Text(text ="$"+sum ,
                style = MaterialTheme.typography.subtitle2,
                color = Color.DarkGray
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            LazyVerticalGrid(
                cells = GridCells.Adaptive(minSize = 200.dp),
                modifier = Modifier.padding(20.dp)
            ) {

                items(subCategoriesList) { subCategories ->
                    SubCategoriesListItem(subCategories = subCategories)
                }
            }
        }
    }
}
