package com.example.walle.features.settings

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.walle.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingsPage() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Settings")
                },
            )
        }
    ) {

        Column {

            SettingItem(
                icon = R.drawable.ic_wallet,
                onClick = {

                },
            ) {
                Column {
                    Text("Wallets")
                    Text("Wallet 1", style = MaterialTheme.typography.caption)
                }
            }
            Divider()
            SettingItem(
                icon = R.drawable.qr_code, text = "Scan QR code",
                onClick = {

                },
            ) {}
            SettingItem(
                icon = R.drawable.qr_code, text = "WalletConnect",
                onClick = {

                },
            ) {}
            Divider()
            SettingItem(
                icon = R.drawable.qr_code, text = "Preferences",
                onClick = {

                },
            ) {}
            SettingItem(
                icon = R.drawable.qr_code, text = "Security",
                onClick = {

                },
            ) {}
            Divider()
            SettingItem(
                icon = R.drawable.qr_code, text = "Help Center",
                onClick = {

                },
            ) {}
            SettingItem(
                icon = R.drawable.qr_code, text = "About",
                onClick = {

                },
            ) {}
        }
    }
}

@Composable
fun SettingItem(

    @DrawableRes icon: Int,
    text: String? = null,
    onClick: () -> Unit,
    content: @Composable (() -> Unit)?
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(12.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
//        Icon(
//            painter = painterResource(id = icon),
//            contentDescription = "icon",
//            modifier = Modifier.size(26.dp),
//        )
        Box(modifier = Modifier.width(8.dp))
        if (text != null) Text(text)
        if (content != null) {
            content()
        }

    }

}

@Preview
@Composable
fun SettingPage_Preview() {
    SettingsPage()
}