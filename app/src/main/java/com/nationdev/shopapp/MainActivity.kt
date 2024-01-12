package com.nationdev.shopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nationdev.shopapp.extensions.toBrazilianCurrency
import com.nationdev.shopapp.model.Product
import com.nationdev.shopapp.ui.theme.Purple40
import com.nationdev.shopapp.ui.theme.ShopAppTheme
import com.nationdev.shopapp.ui.theme.Teal200
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopAppTheme {
                Surface {
                    ProductsSection()
                }
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Surface (
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ){
        Column (
            Modifier
                .heightIn(250.dp)
                .width(200.dp)
        ){
            val imageSize = 100.dp
            Box(modifier = Modifier
                .height(imageSize)
                .background(brush = Brush.horizontalGradient(colors = listOf(Purple40, Teal200)))
                .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = "Imagem do produto",
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop

                )
            }
            Spacer(modifier = Modifier.height(imageSize/2))
            Column (Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}
@Composable
fun ProductsSection(){
    Column {
        Text(text = "Promoções",
            Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )

        Row(
            Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp),

        ){
            Spacer(Modifier)
            ProductItem(Product(name = "Davi", price = BigDecimal("39.90"), image = R.drawable.davi))
            ProductItem(Product(name = "Sara", price = BigDecimal("39.90"), image = R.drawable.sara))
            ProductItem(Product(name = "Kitsune", price = BigDecimal("12.50"), image = R.drawable.kitsune))
            ProductItem(Product(name = "Venom", price = BigDecimal("12.50"), image = R.drawable.venom))
            Spacer(Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(Product(
        name = "No image",
        price = BigDecimal("30.00"),
        image = R.drawable.placeholder
    ))
}

@Preview(showBackground = true, widthDp = 600)
@Composable
fun ProductsSectionPreview() {
    ProductsSection()
}