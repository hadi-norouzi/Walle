package com.example.walle.features.phrase.data

import wallet.core.jni.HDWallet

class PhraseLocalDataSourceImpl: PhraseLocalDataSource {
    override fun generateMnemonics(): String {
        return HDWallet(256, "").mnemonic()
    }
}