package com.example.walle.features.wallet.data

import com.example.walle.features.wallet.domain.entity.Wallet
import kotlinx.coroutines.flow.Flow

interface WalletRepository {

    val selectedWallet: Flow<Wallet>

    suspend fun getDefaultWallet(): Wallet
}