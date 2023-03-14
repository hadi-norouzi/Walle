package com.example.walle.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.walle.features.wallet.data.model.WalletModel
import kotlinx.coroutines.flow.Flow


@Dao
interface WalletDao {

    @Query("select * from wallets")
    suspend fun getWallets(): List<WalletModel>

    @Query("select * from wallets where isDefault = true")
    fun getDefaultWallet(): Flow<WalletModel>

    @Insert
    suspend fun insertWallet(wallet: WalletModel)
}