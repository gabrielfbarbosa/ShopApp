package com.nationdev.shopapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nationdev.shopapp.model.Product
import com.nationdev.shopapp.sampledata.sampleSections
import com.nationdev.shopapp.ui.components.CardProductItem
import com.nationdev.shopapp.ui.components.ProductsSection
import com.nationdev.shopapp.ui.components.sampleProducts
import com.nationdev.shopapp.ui.theme.ShopAppTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    Column {
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            onValueChange = { newValue ->
                text = newValue
            }, Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(35),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "ícone de lupa")
            },
            label = {
                Text(text = "Produto")
            },
            placeholder = {
                Text("O que você procura?")
            }
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(sampleProducts) { p ->
                CardProductItem(
                    product = p,
                    Modifier.padding(horizontal = 16.dp),
                )
            }
//            for (section in sections) {
//                val title = section.key
//                val products = section.value
//                item {
//                    ProductsSection(
//                        title = title,
//                        products = products
//                    )
//                }
//            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    ShopAppTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}