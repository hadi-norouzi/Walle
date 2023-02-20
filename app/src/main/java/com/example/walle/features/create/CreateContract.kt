package com.example.walle.features.create

class CreateContract {


    interface CreatePresenterInterface {

        fun getRandomMnemonic()
    }

    interface CreateViewInterface {

        fun displayMnemonics()
        fun validateMnemonics()

    }
}