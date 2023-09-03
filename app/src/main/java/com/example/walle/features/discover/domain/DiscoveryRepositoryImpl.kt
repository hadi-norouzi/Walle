package com.example.walle.features.discover.domain

import com.example.walle.features.discover.data.DiscoveryDataSource
import com.example.walle.features.discover.data.HistoryEntity
import com.example.walle.features.discover.data.fromModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DiscoveryRepositoryImpl(
    private val dataSource: DiscoveryDataSource
) : DiscoveryRepository {


    override fun getAllHistory(): Flow<List<History>> = dataSource.getHistory().map {
        it.map { model -> model.fromModel() }
    }

    override fun storeHistory(history: History) {
        dataSource.storeHistory(
            history.toEntity()
        )
    }
}