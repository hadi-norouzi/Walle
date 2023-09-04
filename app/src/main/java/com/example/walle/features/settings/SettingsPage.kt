package com.example.walle.features.settings

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.walle.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsPage(navController: NavController) {

    val dark = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Settings")
                },
            )
        }
    ) {

        Column(modifier = Modifier.padding(it)) {

            SettingItem(
                icon = R.drawable.ic_wallet,
                onClick = {

                    navController.navigate("/wallets")
                },
            ) {
                Column {
                    Text("Wallets")
                    Text("Wallet 1", style = MaterialTheme.typography.bodySmall)
                }
            }
            Divider()
            SettingItem(
                icon = if (!dark.value) R.drawable.light_mode else R.drawable.dark_mode,
                text = "Change Theme"
            ) {

                Switch(
                    checked = dark.value,
                    onCheckedChange = {
                        dark.value = !dark.value
                    },
                )

            }
            Divider()
            SettingItem(
                icon = R.drawable.qr_code, text = "Scan QR code",
                onClick = {

                },
            )
            SettingItem(
                text = "WalletConnect",
                onClick = {

                },
            )
            Divider()
            SettingItem(
                text = "Preferences",
                onClick = {

                },
            )
            SettingItem(
                text = "Security",
                onClick = {

                },
            )
            Divider()
            SettingItem(
                text = "Help Center",
                onClick = {

                },
            )
            SettingItem(
                icon = R.drawable.info_ic, text = "About",
                onClick = {

                },
            )
        }
    }
}

@Composable
fun SettingItem(

    @DrawableRes icon: Int? = null,
    text: String? = null,
    onClick: (() -> Unit)? = null,
    content: @Composable (() -> Unit)? = null
) {


    Row(
        modifier = Modifier
            .let {

                if (onClick != null)
                    return@let it.clickable(onClick = onClick)
                it
            }
            .fillMaxWidth()
            .padding(12.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (icon != null)
            Row {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "icon",
                    modifier = Modifier.size(26.dp),
                )
                Box(modifier = Modifier.width(12.dp))
            }
        if (text != null) Text(text, modifier = Modifier.weight(1f))
        if (content != null) {
            content()
        }

    }

}

@Preview
@Composable
fun SettingPage_Preview() {
    SettingsPage(rememberNavController())
}