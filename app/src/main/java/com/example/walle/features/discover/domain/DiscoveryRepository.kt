package com.example.walle.features.discover.domain

import kotlinx.coroutines.flow.Flow

interface DiscoveryRepository {

    val allHistory: Flow<List<History>>


    fun storeHistory(history: History)
}

