package com.example.walle.features.discover.domain

import android.net.Uri
import com.example.walle.features.discover.data.HistoryEntity
import java.util.Date

data class History(
    val name: String,
    val createdAt: Date,
    val url: Uri,
    val icon: Uri? = null
)


fun History.toEntity(): HistoryEntity {
    return HistoryEntity(
        url = name,
        createdTime = createdAt.time,
        icon = icon.toString()
    )
}

