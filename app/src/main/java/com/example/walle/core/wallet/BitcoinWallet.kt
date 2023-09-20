package com.example.walle.core.wallet

import com.example.walle.core.bitcoin.Bitcoin
import com.example.walle.core.model.CoinInfo
import com.example.walle.core.model.bitcoin.BitcoinUnsignedTx

class BitcoinWallet(
    var mnemonics: List<String>?,
    var privateKey: String,
    var phraseType: PhraseType,
) : Wallet<BitcoinUnsignedTx>() {
    private var coin: Bitcoin? = null

    init {
        generateCoins()
    }


    constructor(privateKey: String) : this(mutableListOf(), "", PhraseType.MNEMONICS) {
        mnemonics = null
        this.privateKey = privateKey
        this.phraseType = PhraseType.PRIVATE_KEY
        generateCoins()
    }

    override fun generateCoins() {
        coin = if (phraseType === PhraseType.MNEMONICS) {
            Bitcoin(mnemonics!!)
        } else {
            Bitcoin(this.privateKey!!)
        }
    }

    override fun generateTokens() {
    }

    override fun getAllCoinsInfo(): List<CoinInfo>? {
        if (coin != null) {
            val coinsInfo: MutableList<CoinInfo> = ArrayList()
            coinsInfo.add(coin!!.getInfo()!!)
            return coinsInfo
        }
        return null
    }

    override fun getVersion() = 1
}
