package com.example.walle.features.discover.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.walle.features.discover.domain.History
import java.util.Date

@Entity(tableName = "browser_history")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val url: String,
    val createdTime: Long
)

fun HistoryEntity.fromModel(): History {

    return History(
        name = url,
        createdAt = Date(createdTime)
    )
}