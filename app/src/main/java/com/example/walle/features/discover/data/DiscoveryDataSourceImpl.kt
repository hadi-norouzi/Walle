package com.example.walle.features.discover.data

import com.example.walle.core.database.DiscoveryDao
import kotlinx.coroutines.flow.Flow

class DiscoveryDataSourceImpl(
    private val dao: DiscoveryDao
) : DiscoveryDataSource {
    override fun getHistory(): Flow<List<HistoryEntity>> = dao.getAllHistory()
    override fun storeHistory(historyEntity: HistoryEntity) {
        dao.insert(historyEntity)
    }

}