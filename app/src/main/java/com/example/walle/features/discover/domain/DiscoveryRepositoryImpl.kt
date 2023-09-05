package com.example.walle.features.discover.domain

import android.net.Uri
import com.example.walle.features.discover.data.DiscoveryDataSource
import com.example.walle.features.discover.data.HistoryEntity
import com.example.walle.features.discover.data.fromModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DiscoveryRepositoryImpl(
    private val dataSource: DiscoveryDataSource
) : DiscoveryRepository {


    override val allHistory: Flow<List<History>> = dataSource.getHistory().map {
        it.map { model -> model.fromModel() }
    }

    override fun storeHistory(history: History) {
        val historyCopy: History
        val icon =
            Uri.Builder()
                .scheme("https")
                .authority(history.url.toString())
                .path("favicon.ico")
                .clearQuery().build()
        historyCopy = history.copy(icon = icon)
        dataSource.storeHistory(
            historyCopy.toEntity()
        )
    }
}