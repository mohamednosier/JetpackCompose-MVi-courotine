package com.mohamed.nosier.kotlin.android.categoriescompose.data.model

import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("image") val image: String = "",
    @SerializedName("title") val title: String = "",
)

