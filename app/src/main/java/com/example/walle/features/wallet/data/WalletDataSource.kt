package com.example.walle.features.wallet.data

import com.example.walle.core.Coin
import com.example.walle.features.wallet.data.model.WalletModel
import kotlinx.coroutines.flow.Flow


interface WalletDataSource {

    val defaultWallet: Flow<WalletModel>

    suspend fun getSupportedCoins(mnemonic: List<String>): Flow<List<Coin>>

    suspend fun getDefaultWallet(): WalletModel

    suspend fun addWallet(wallet: WalletModel)

    suspend fun getWallets(): List<WalletModel>

    suspend fun deleteWallet(wallet: WalletModel)


}