package com.example.walle.navigation

sealed class NavigationItem(var route:String,var title:String){
    object Splash: NavigationItem(route = Screen.Splash.route, title = "Splash")
}

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Intro : Screen("intro")
    object CreateWallet : Screen("intro")
    object Wallet : Screen("wallet")
    object CreatePhrase : Screen("create_phrase")
    object ChooseCoin : Screen("choose_coin")


}
