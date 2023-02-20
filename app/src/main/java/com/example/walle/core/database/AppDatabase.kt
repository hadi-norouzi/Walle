package com.example.walle.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.walle.features.wallet.data.model.WalletModel


@Database(entities = [WalletModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun walletDao(): WalletDao
}