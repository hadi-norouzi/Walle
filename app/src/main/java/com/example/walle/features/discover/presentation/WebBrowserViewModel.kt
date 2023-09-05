package com.example.walle.features.discover.presentation

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walle.features.discover.domain.DiscoveryRepository
import com.example.walle.features.discover.domain.History
import kotlinx.coroutines.launch
import java.util.Date

class WebBrowserViewModel(
    private val repository: DiscoveryRepository
) : ViewModel() {

    init {

    }

    fun saveUrl(url: String) {
        viewModelScope.launch {
            repository.storeHistory(
                History(
                    name = url,
                    createdAt = Date(System.currentTimeMillis()),
                    url = Uri.parse(url),
                )
            )
        }
    }
}