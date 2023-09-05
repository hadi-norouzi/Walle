package com.example.walle.features.wallet.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.walle.core.Coin


@Entity(tableName = "wallets")
data class WalletModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val privateKey: String,
    val isDefault: Boolean = false,
    val coins: List<Coin>
)