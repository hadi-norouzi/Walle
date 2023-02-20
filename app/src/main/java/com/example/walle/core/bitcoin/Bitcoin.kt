package com.example.walle.core.bitcoin

import com.example.walle.core.Coin
import wallet.core.jni.AnyAddress
import wallet.core.jni.CoinType
import wallet.core.jni.HDWallet
import wallet.core.jni.PrivateKey
import wallet.core.jni.PublicKey

class Bitcoin constructor(
    mnemonics: List<String>,
) : Coin() {

    private val mPrivateKey: PrivateKey = generatePrivateKey(mnemonics)
    private val mPublicKey = generatePublicKey(mnemonics)


    companion object {
        fun generatePrivateKey(mnemonics: List<String>): PrivateKey {
            val wallet = HDWallet(mnemonics.joinToString(" "), "")
            val pk = wallet.getKey(CoinType.BITCOIN, CoinType.BITCOIN.derivationPath()).data()
            return PrivateKey(pk)
        }

        fun generatePublicKey(mnemonics: List<String>): PublicKey {
            val wallet = HDWallet(mnemonics.joinToString(" "), "")
            return wallet.getKey(CoinType.BITCOIN, CoinType.BITCOIN.derivationPath())
                .getPublicKeySecp256k1(true)
        }
    }

    override val address: String
        get() = AnyAddress(publicKey, CoinType.BITCOIN).description()

    override val publicKey: String
        get() = mPublicKey.description()

    override val privateKey: String
        get() = mPrivateKey.data().decodeToString()

    override val iso: String
        get() = "BTC"

    override val name: String
        get() = "Bitcoin"

    override val networkName: String
        get() = "BITCOIN"

    override val coinType: CoinType
        get() = CoinType.BITCOIN

    override val decimals: Int = 8
}