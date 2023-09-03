package com.example.walle.features.discover.presentation

import androidx.lifecycle.ViewModel
import com.example.walle.features.discover.domain.DiscoveryRepository

class DiscoveryViewModel(
    private val discoveryRepository: DiscoveryRepository
): ViewModel() {

    init {

    }


    val browsingHistory = discoveryRepository.getAllHistory()
}