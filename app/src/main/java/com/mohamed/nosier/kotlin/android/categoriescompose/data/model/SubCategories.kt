package com.mohamed.nosier.kotlin.android.categoriescompose.data.model

import com.google.gson.annotations.SerializedName

data class SubCategories(
    @SerializedName("id") val id: Long = 0,
    @SerializedName("title") val title: String = "",
    @SerializedName("minBudget") val minBudget: Int = 0,
    @SerializedName("maxBudget") val maxBudget: Int = 0,
    @SerializedName("avgBudget") val avgBudget: Int = 0,
    @SerializedName("image") val image: String = ""

)
