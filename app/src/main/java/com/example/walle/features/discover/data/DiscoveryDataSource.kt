package com.example.walle.features.discover.data

import kotlinx.coroutines.flow.Flow

interface DiscoveryDataSource {

    fun getHistory(): Flow<List<HistoryEntity>>

    fun storeHistory(historyEntity: HistoryEntity)
}