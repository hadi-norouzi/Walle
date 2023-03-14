package com.example.walle.features.wallet.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walle.features.import.presentation.ImportState
import com.example.walle.features.wallet.data.WalletRepository
import com.example.walle.features.wallet.domain.entity.Wallet
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WalletViewModel constructor(
    walletRepository: WalletRepository
) : ViewModel() {


    val currentWallet: StateFlow<WalletState> =
        walletRepository.selectedWallet.map { WalletState.Success(it) }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = WalletState.Loading,
        )
}

sealed interface WalletState {
    object Loading : WalletState
    class Success(val wallet: Wallet) : WalletState
}