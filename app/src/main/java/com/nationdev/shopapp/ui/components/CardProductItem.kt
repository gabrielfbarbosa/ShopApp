package com.nationdev.shopapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nationdev.shopapp.R
import com.nationdev.shopapp.extensions.toBrazilianCurrency
import com.nationdev.shopapp.model.Product
import com.nationdev.shopapp.ui.theme.ShopAppTheme
import java.math.BigDecimal


@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    expanded: Boolean = false
) {
    var expandedState by remember {
        mutableStateOf(expanded)
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable {
                       expandedState = !expandedState
            },
        elevation = CardDefaults.cardElevation(elevation)
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                placeholder = painterResource(id = R.drawable.noimage),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toBrazilianCurrency()
                )
            }
            val textOverflow =
                if (expandedState) TextOverflow.Visible
                else TextOverflow.Ellipsis
            val maxLines =
                if (expandedState) Int.MAX_VALUE
                else 2
            product.description?.let {
                Text(
                    text = product.description,
                    Modifier
                        .padding(16.dp),
                    overflow = textOverflow,
                    maxLines = maxLines
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    ShopAppTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "teste",
                    price = BigDecimal("99.99")
                ),
            )
        }
    }
}

@Preview
@Composable
fun CardProductItemWithDescriptionPreview() {
    ShopAppTheme {
        Surface {
            CardProductItem(
                product = Product(
                    "teste",
                    BigDecimal("9.99"),
                    description = LoremIpsum(10).values.first(),
                ),
            )
        }
    }
}

@Preview
@Composable
fun CardProductItemWithDescriptionExpandedPreview() {
    ShopAppTheme {
        Surface {
            CardProductItem(
                product = Product(
                    "teste",
                    BigDecimal("9.99"),
                    description = LoremIpsum(50).values.first(),
                ),
                expanded = true,
            )
        }
    }
}