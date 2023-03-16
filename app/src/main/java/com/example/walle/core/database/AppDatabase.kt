package com.example.walle.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.walle.core.database.model.BrowserHistoryModel
import com.example.walle.features.wallet.data.model.WalletModel


@Database(entities = [WalletModel::class, BrowserHistoryModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun walletDao(): WalletDao

    abstract fun browserDao(): BrowserDao
}