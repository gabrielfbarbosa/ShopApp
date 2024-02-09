package com.nationdev.shopapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nationdev.shopapp.model.Product
import com.nationdev.shopapp.ui.theme.ShopAppTheme
import java.math.BigDecimal

@Composable
fun ProductsSection(
    title: String,
    products: List<Product>
) {
    Column {
        Text(
            text = title,
            Modifier
                .padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        LazyRow(
            Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products) {p ->
                ProductItem(product = p)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsSectionPreview() {
    ShopAppTheme {
        Surface {
            ProductsSection("Promoções", products = sampleProducts)
        }
    }
}


val sampleProducts = listOf(
    Product(
        name = "Davi",
        price = BigDecimal("39.90"),
        image = "https://www.otempo.com.br/image/contentid/policy:1.2838645:1679957625/davi-jpg.jpg?f=3x2&w=1224"
    ),

    Product(
        name = "Sara",
        price = BigDecimal("39.90"),
        image = "https://criticalhits.com.br/wp-content/uploads/2021/08/Kujou-sara.jpg"
    ),

    Product(
        name = "Kitsune",
        price = BigDecimal("12.50"),
        image = "https://acdn.mitiendanube.com/stores/003/317/647/products/kitsune-4dc29761789be3417217040582094703-1024-1024.png"
    ),

    Product(
        name = "Venom",
        price = BigDecimal("12.50"),
        image = "https://img.olhardigital.com.br/wp-content/uploads/2023/10/Venom-1.jpg"
    )
)