package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.categories.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.Categories
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.common.RoundedImage
import com.mohamed.nosier.kotlin.android.categoriescompose.R
@SuppressLint("SuspiciousIndentation")
@Composable
fun CategoriesListItem(
    categories: Categories,
    onItemClick: (Categories) -> Unit
) {
    val paddingXXSmall = dimensionResource(id = R.dimen.padding_xxsmall)
    val paddingMedium = dimensionResource(id = R.dimen.padding_medium)
    val avatarSize = dimensionResource(id = R.dimen.avatar_size_medium)


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(Color.White, shape = RoundedCornerShape(5.dp))
                .clickable {
                    onItemClick(categories)
                }
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingMedium)
            ) {
                RoundedImage(
                    url = categories.image,
                    placeholder = R.drawable.avatar_placeholder,
                    modifier = Modifier
                        .size(avatarSize)
                        .padding(end = paddingMedium)
                )
                Column {

                    Text(
                        text = categories.title,
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

        }
    }
