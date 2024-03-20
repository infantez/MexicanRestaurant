package neiz.fz.compose.view.dish

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import neiz.fz.compose.R
import neiz.fz.compose.ui.theme.PrimaryColor
import neiz.fz.compose.view.common.BoxBackground
import neiz.fz.compose.view.common.SpacerComponent
import neiz.fz.compose.view.common.TextComponent

@Composable
fun DishScreen(paddingValues: PaddingValues) {

    BoxBackground()

    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)

    ){
        LazyVerticalGrid(
            columns = GridCells
                .Fixed(2),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){

            items(4){
                DishItem()
            }

        }
    }
}

@Composable
fun DishItem(
    modifier: Modifier = Modifier
) {
    Card(
        border = BorderStroke(
            width = 2.dp,
            color = PrimaryColor),
        modifier = modifier
            .fillMaxWidth()
            .clickable {

            }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                painter = painterResource(id = R.drawable.lomo_saltado),
                contentDescription = "Template",
                contentScale = ContentScale.Crop
            )
            SpacerComponent(modifier = Modifier.height(12.dp))
            TextComponent(
                text = "Arroz Chaufa",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            SpacerComponent(modifier = Modifier.height(12.dp))
            TextComponent(
                text = "Carbohidratos",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            )

            TextComponent(
                text = "20.8",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                    // color = PrimaryColor
                )
            )

            SpacerComponent(modifier = Modifier.height(12.dp))
            TextComponent(
                text = "Precio",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            )

            TextComponent(
                text = "$20.00 mxn",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                    // color = PrimaryColor
                )
            )

            RatingBar(currentRating = 4)
        }
    }
}

@Composable
fun RatingBar(
    maxRating:Int = 5,
    currentRating:Int,
    starsColor:Color = Color.Yellow
) {
    Row() {
        for (i in 1..maxRating) {
            Icon(imageVector =
            if (i <= currentRating) {
                Icons.Filled.Star
            } else {
                Icons.Filled.StarOutline
            },
                contentDescription = "Rating",
                tint =
                if (i <= currentRating) {
                    starsColor
                } else {
                    Color.Unspecified
                },
                modifier = Modifier
                    .clickable {

                    }
                    .padding(2.dp)
            )
        }
    }
}
