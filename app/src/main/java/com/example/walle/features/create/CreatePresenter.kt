package com.example.walle.features.create

import com.example.walle.features.create.domain.PhraseRepository

class CreatePresenter(
    val view: CreateContract.CreateViewInterface,
    private val repository: PhraseRepository,
) : CreateContract.CreatePresenterInterface {



    init {
        getRandomMnemonic()
    }

    override fun getRandomMnemonic() {
//        repository.generateMnemonics()
    }


}