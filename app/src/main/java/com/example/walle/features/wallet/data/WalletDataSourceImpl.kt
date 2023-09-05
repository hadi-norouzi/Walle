package com.example.walle.features.wallet.data

import com.example.walle.core.Coin
import com.example.walle.core.bitcoin.Bitcoin
import com.example.walle.core.database.WalletDao
import com.example.walle.features.wallet.data.model.WalletModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import wallet.core.jni.CoinType

class WalletDataSourceImpl(private val walletDao: WalletDao) : WalletDataSource {

    override val defaultWallet: Flow<WalletModel> = walletDao.getDefaultWallet()
    override suspend fun getSupportedCoins(mnemonic: List<String>): Flow<List<Coin>> = flow {
        emit(getStaticSupportedCoins(mnemonic))
    }


    override suspend fun getDefaultWallet(): WalletModel {
        val wallets = walletDao.getWallets()
        if (wallets.isEmpty()) {
            throw WalletNotFound()
        }
        val foundWallet = wallets.find { it.isDefault }

        return foundWallet ?: wallets.first()
    }

    override suspend fun addWallet(wallet: WalletModel) {
        walletDao.insertWallet(wallet)
    }

    override suspend fun getWallets(): List<WalletModel> {
        return walletDao.getWallets()
    }

    override suspend fun deleteWallet(wallet: WalletModel) {
        walletDao.delete(wallet)
    }

    private fun getStaticSupportedCoins(mnemonic: List<String>): List<Coin> {
        return listOf(
            Bitcoin(mnemonic),
        )
    }
}

class WalletNotFound: Exception()