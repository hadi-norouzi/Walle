package com.example.walle.features.wallet.data

import com.example.walle.core.database.WalletDao
import com.example.walle.features.wallet.data.model.WalletModel

class WalletDataSourceImpl(private val walletDao: WalletDao) : WalletDataSource {

    override suspend fun getDefaultWallet(): WalletModel {
        val wallets = walletDao.getWallets()
        if (wallets.isEmpty()) {
            throw java.lang.Exception("Wallet is Empty")
        }
        val foundWallet = wallets.find { it.isDefault }

        return foundWallet ?: wallets.first()
    }

    override suspend fun addWallet(wallet: WalletModel) {
        walletDao.insertWallet(wallet)
    }

    override suspend fun getWallets(): List<WalletModel> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWallet(wallet: WalletModel) {
        TODO("Not yet implemented")
    }
}