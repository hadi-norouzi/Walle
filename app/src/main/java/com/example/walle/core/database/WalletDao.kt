package com.example.walle.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.walle.features.wallet.data.model.WalletModel


@Dao
interface WalletDao {

    @Query("select * from wallets")
    suspend fun getWallets(): List<WalletModel>

    @Insert
    suspend fun insertWallet(wallet: WalletModel)
}