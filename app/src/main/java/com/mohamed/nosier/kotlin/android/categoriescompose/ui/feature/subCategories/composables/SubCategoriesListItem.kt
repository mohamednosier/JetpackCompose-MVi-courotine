package com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.subCategories.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CallSplit
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mohamed.nosier.kotlin.android.categoriescompose.R
import com.mohamed.nosier.kotlin.android.categoriescompose.data.model.SubCategories
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.feature.common.RoundedImage
import com.mohamed.nosier.kotlin.android.categoriescompose.ui.theme.OnSurfaceTextAlpha

@Composable
fun SubCategoriesListItem(subCategories: SubCategories) {
    val paddingXXSmall = dimensionResource(id = R.dimen.padding_xxsmall)
    val paddingSmall = dimensionResource(id = R.dimen.padding_small)
    val paddingMedium = dimensionResource(id = R.dimen.padding_medium)
    val avatarSize = dimensionResource(id = R.dimen.avatar_size_medium)
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .background(Color.White, shape = RoundedCornerShape(5.dp))
            .clip(shape = RoundedCornerShape(20.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingMedium)
        ) {
            Column {
                RoundedImage(
                    url = subCategories.image,
                    placeholder = R.drawable.avatar_placeholder,
                    modifier = Modifier
                        .size(avatarSize)
                        .padding(end = paddingMedium)
                )
                Text(
                    text = subCategories.title,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )


                Spacer(modifier = Modifier.size(paddingSmall))


                CounterSession(subCategories = subCategories)
            }
        }
        Divider()
    }
}

@Composable
fun CounterSession(subCategories: SubCategories) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        CounterItem( counterText ="$ "+ subCategories.minBudget.toString())
        CounterItem( counterText ="$ "+ subCategories.avgBudget.toString())
        CounterItem( counterText ="$ "+ subCategories.maxBudget.toString())
    }
}

@Composable
fun CounterItem(
//    icon: ImageVector,
    counterText: String
) {
//    Icon(
//        imageVector = icon,
//        contentDescription = null,
//        tint = MaterialTheme.colors.onSurface.copy(alpha = OnSurfaceTextAlpha)
//    )
//    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_xsmall)))
    Text(
        text = counterText,
        style = MaterialTheme.typography.caption,
    )
    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_small)))
}
