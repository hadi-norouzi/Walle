package com.example.walle.features.wallet.data

import com.example.walle.features.wallet.data.model.WalletModel


interface WalletDataSource {

    suspend fun getDefaultWallet(): WalletModel

    suspend fun addWallet(wallet: WalletModel)

    suspend fun getWallets(): List<WalletModel>

    suspend fun deleteWallet(wallet: WalletModel)


}