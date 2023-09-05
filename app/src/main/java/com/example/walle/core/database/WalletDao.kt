package com.example.walle.core.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.walle.features.wallet.data.model.WalletModel
import kotlinx.coroutines.flow.Flow


@Dao
interface WalletDao {

    @Query("select * from wallets")
    fun getWallets(): List<WalletModel>

    @Query("select * from wallets where isDefault = true")
    fun getDefaultWallet(): Flow<WalletModel>

    @Insert
    fun insertWallet(wallet: WalletModel)

    @Delete
    fun delete(wallet: WalletModel)
}