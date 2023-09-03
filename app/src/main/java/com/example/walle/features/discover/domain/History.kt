package com.example.walle.features.discover.domain

import com.example.walle.features.discover.data.HistoryEntity
import java.util.Date

data class History(
    val name: String,
    val createdAt: Date
)


fun History.toEntity(): HistoryEntity {
    return HistoryEntity(
        url = name,
        createdTime = createdAt.time,
    )
}

