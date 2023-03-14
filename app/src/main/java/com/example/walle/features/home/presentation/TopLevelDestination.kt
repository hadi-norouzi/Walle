package com.example.walle.features.home.presentation

import com.example.walle.R
import com.example.walle.resources.Icon.ImageVectorIcon
import com.example.walle.resources.Icon.DrawableResourceIcon
import com.example.walle.resources.Icon
import com.example.walle.resources.WalleIcons


enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    WALLET(
        selectedIcon = DrawableResourceIcon(WalleIcons.Wallet),
        unselectedIcon = DrawableResourceIcon(WalleIcons.Wallet),
        iconTextId = R.string.wallet,
        titleTextId = R.string.wallet_id,
    ),
    DISCOVER(
        selectedIcon = DrawableResourceIcon(WalleIcons.Discover),
        unselectedIcon = DrawableResourceIcon(WalleIcons.Discover),
        iconTextId = R.string.discover,
        titleTextId = R.string.discover_id,
    ),
    SETTING(
        selectedIcon = DrawableResourceIcon(WalleIcons.Settings),
        unselectedIcon = DrawableResourceIcon(WalleIcons.Settings),
        iconTextId = R.string.settings,
        titleTextId = R.string.settings_id,
    )
}