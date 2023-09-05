package com.example.walle.features.discover.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walle.features.discover.domain.DiscoveryRepository
import kotlinx.coroutines.flow.flowOn

class DiscoveryViewModel(
    private val discoveryRepository: DiscoveryRepository
): ViewModel() {

    init {

    }


    val browsingHistory = discoveryRepository.allHistory
}