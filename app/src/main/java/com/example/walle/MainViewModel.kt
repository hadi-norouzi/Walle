package com.example.walle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walle.features.wallet.data.WalletNotFound
import com.example.walle.features.wallet.data.WalletRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: WalletRepository
) : ViewModel() {

    val hasWallet: Flow<Boolean> = repository.selectedWallet
        .catch { false }
        .map { true }
//        flow {
//        try {
//            viewModelScope.launch {
//                repository.selectedWallet.collect()
//                emit(true)
//            }
//        } catch (e: WalletNotFound) {
//            emit(false)
//        }
//    }
}