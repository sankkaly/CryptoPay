package com.example.cryptopay

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cryptopay.model.items
import com.example.cryptopay.ui.theme.CryptoPayTheme
import com.example.cryptopay.view.start.WalkthroughScreen
import com.example.cryptopay.view.walletSetup.ImportSeed
import com.example.cryptopay.view.walletSetup.WalletSetup


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoPayTheme {
//                SplashScreen()
//                WalkthroughScreen(items)
//                WalletSetup()
                ImportSeed()
            }
        }
    }
}

