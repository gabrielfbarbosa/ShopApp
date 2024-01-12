package com.nationdev.shopapp.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nationdev.shopapp.R
import com.nationdev.shopapp.model.Product
import java.math.BigDecimal

@Composable
fun ProductsSection(
    title: String,
    products: List<Product>
){
    Column {
        Text(text = title,
            Modifier
                .padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        Row(
            Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp),

            ){
            Spacer(Modifier)
            for (p in products){
                ProductItem(product = p)
            }

            Spacer(Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsSectionPreview() {
    ProductsSection("Promoções", sampleProducts)
}


val sampleProducts = listOf(
    Product(
        name = "Davi",
        price = BigDecimal("39.90"),
        image = R.drawable.davi
    ),

    Product(
        name = "Sara",
        price = BigDecimal("39.90"),
        image = R.drawable.sara
    ),

    Product(
        name = "Kitsune",
        price = BigDecimal("12.50"),
        image = R.drawable.kitsune
    ),

    Product(
        name = "Venom",
        price = BigDecimal("12.50"),
        image = R.drawable.venom
    )
)