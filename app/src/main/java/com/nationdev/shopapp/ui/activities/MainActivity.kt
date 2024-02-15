package com.nationdev.shopapp.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.nationdev.shopapp.sampledata.sampleSections
import com.nationdev.shopapp.ui.screens.HomeScreen
import com.nationdev.shopapp.ui.theme.ShopAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    ShopAppTheme {
        Surface {
            HomeScreen(
                sampleSections
            )
        }
    }
}