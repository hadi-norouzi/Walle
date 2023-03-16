package com.example.walle.features.discover.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walle.core.database.BrowserDao
import com.example.walle.core.database.model.BrowserHistoryModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DiscoverViewModel constructor(
    val browserDao: BrowserDao,
) : ViewModel() {


//    val history: StateFlow<BrowserHistoryModel> = browserDao.getAllHistories().map { BrowserHistoryModel() }.stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(1000),
//        initialValue = BrowserHistoryModel("", "")
//    )
}