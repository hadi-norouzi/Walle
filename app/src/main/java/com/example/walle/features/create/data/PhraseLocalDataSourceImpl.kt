package com.example.walle.features.create.data

import com.example.walle.core.database.WalletDao
import com.example.walle.features.wallet.data.model.WalletModel
import wallet.core.jni.HDWallet

class PhraseLocalDataSourceImpl constructor(private val walletDao: WalletDao) :
    PhraseLocalDataSource {


    override fun generateMnemonics(): String {
        return HDWallet(256, "").mnemonic()
    }


    override suspend fun createWallet(name: String?, mnemonic: List<String>): WalletModel {
        val wallet = WalletModel(name = name!!, isDefault = true, privateKey = "")
        walletDao.insertWallet(wallet)
        return wallet
    }
}