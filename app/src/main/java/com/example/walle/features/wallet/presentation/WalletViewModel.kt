package com.example.walle.features.wallet.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walle.features.wallet.data.WalletRepository
import com.example.walle.features.wallet.domain.entity.Wallet
import kotlinx.coroutines.launch

class WalletViewModel constructor(private val walletRepository: WalletRepository) : ViewModel() {


    var currentWallet = mutableStateOf<Wallet?>(null)

    init {
        getDefaultWallet()
    }

    private fun getDefaultWallet() {
        viewModelScope.launch {
            try {
                val wallet = walletRepository.getDefaultWallet()
                currentWallet.value = wallet
            } catch (e: java.lang.Exception) {
                println(e)
            }
        }
    }
}