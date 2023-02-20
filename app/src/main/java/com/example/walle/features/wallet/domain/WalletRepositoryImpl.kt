package com.example.walle.features.wallet.domain

import com.example.walle.features.wallet.data.WalletDataSource
import com.example.walle.features.wallet.data.WalletRepository
import com.example.walle.features.wallet.domain.entity.Wallet

class WalletRepositoryImpl constructor(private val walletDataSource: WalletDataSource) :
    WalletRepository {


    override suspend fun getDefaultWallet(): Wallet {
        val wallet = walletDataSource.getDefaultWallet()

        return Wallet(wallet.name)
    }
}