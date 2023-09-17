package com.example.walle.features.wallet.data

import com.example.walle.features.wallet.data.model.Coin
import com.example.walle.features.wallet.domain.entity.Wallet
import kotlinx.coroutines.flow.Flow

interface WalletRepository {


    val selectedWallet: Flow<Wallet>

    val supportedCoins: Flow<List<Coin>>

    suspend fun getDefaultWallet(): Wallet


}
