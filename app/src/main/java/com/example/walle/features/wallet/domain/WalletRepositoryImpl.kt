package com.example.walle.features.wallet.domain

import com.example.walle.features.wallet.data.WalletDataSource
import com.example.walle.features.wallet.data.WalletRepository
import com.example.walle.features.wallet.domain.entity.Wallet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WalletRepositoryImpl constructor(private val walletDataSource: WalletDataSource) :
    WalletRepository {


    override var selectedWallet: Flow<Wallet> = walletDataSource.defaultWallet.map {
        Wallet(it.name)
    }


    override suspend fun getDefaultWallet(): Wallet {
        val wallet = walletDataSource.getDefaultWallet()

        return Wallet(wallet.name)
    }
}