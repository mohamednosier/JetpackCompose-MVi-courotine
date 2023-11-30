package com.mohamed.nosier.kotlin.android.categoriescompose.common

import android.content.Intent
import android.net.Uri

fun buildUrlIntent(url: String) = Intent(Intent.ACTION_VIEW, Uri.parse(url))