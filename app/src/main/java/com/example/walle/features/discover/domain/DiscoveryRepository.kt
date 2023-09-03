package com.example.walle.features.discover.domain

import kotlinx.coroutines.flow.Flow

interface DiscoveryRepository {

    fun getAllHistory(): Flow<List<History>>

    fun storeHistory(history: History)
}

