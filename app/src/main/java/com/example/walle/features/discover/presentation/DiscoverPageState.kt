package com.example.walle.features.discover.presentation

import com.example.walle.core.database.model.BrowserHistoryModel

sealed interface DiscoverPageState {
    object Loading: DiscoverPageState
    data class Success(val history: List<BrowserHistoryModel>): DiscoverPageState
    data class Failure(val message: String): DiscoverPageState
}