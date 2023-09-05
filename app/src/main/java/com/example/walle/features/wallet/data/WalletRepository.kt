package com.example.walle.features.wallet.data

import com.example.walle.features.wallet.domain.entity.Wallet
import kotlinx.coroutines.flow.Flow

interface WalletRepository {


    val selectedWallet: Flow<Wallet>

    val supportedCoins: Flow<List<CoinEntity>>

    suspend fun getDefaultWallet(): Wallet


}