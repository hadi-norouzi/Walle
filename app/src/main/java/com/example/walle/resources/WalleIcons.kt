package com.example.walle.resources

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.walle.R

object WalleIcons {


    /// Bottom navigation icons
    const val Wallet = R.drawable.ic_wallet
    const val Discover = R.drawable.explore_ic
    const val Settings = R.drawable.settings_ic

    /// Wallet page icons
    const val Buy = R.drawable.credit_card_ic
    const val Swap = R.drawable.swap_horiz_ic
    const val Receive = R.drawable.arrow_downward_ic
    const val Send = R.drawable.arrow_upward_ic

    const val Configure = R.drawable.tune_ic


}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector): Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int): Icon()
}