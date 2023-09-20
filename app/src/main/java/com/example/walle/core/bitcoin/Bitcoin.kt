package com.example.walle.core.bitcoin

import com.example.walle.core.Coin
import com.example.walle.core.Util.fromHexString
import com.example.walle.core.model.TxField
import wallet.core.jni.AnyAddress
import wallet.core.jni.CoinType
import wallet.core.jni.HDWallet
import wallet.core.jni.PrivateKey
import wallet.core.jni.PublicKey

class Bitcoin(
    mnemonics: List<String>,
) : Coin() {

    private var mPrivateKey: PrivateKey = generatePrivateKey(mnemonics)
    private var mPublicKey = generatePublicKey(mnemonics)

    constructor(privateKey: String) : this(mutableListOf()) {
        val bytes: ByteArray = fromHexString(privateKey)
        mPrivateKey = PrivateKey(bytes)
        mPublicKey = this.mPrivateKey.getPublicKeySecp256k1(true)
    }


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

    override val transactionFields: List<TxField?>
        get() = mutableListOf()
}
