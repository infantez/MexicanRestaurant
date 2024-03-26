package neiz.fz.compose.view.dish

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import neiz.fz.compose.domain.model.Dish
import neiz.fz.compose.ui.theme.PrimaryColor
import neiz.fz.compose.view.common.BoxBackground
import neiz.fz.compose.view.common.SpacerComponent
import neiz.fz.compose.view.common.TextComponent

@Composable
fun DishScreen(
    viewmodel : DishViewModel = hiltViewModel(),
    paddingValues: PaddingValues) {


    val state = viewmodel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewmodel.getDishes()
    }

    if (state.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = PrimaryColor,
                strokeWidth = 4.dp
            )
        }
    }

    if (state.error != null) {
        Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
    }

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

            state.success?.let{ dishes->
                items(dishes){dish->
                    DishItem(
                        dish = dish,
                        context = context
                    )
                }
            }
        }
    }
}

@Composable
fun DishItem(
    modifier: Modifier = Modifier,
    dish: Dish,
    context: Context
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
            /*
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                painter = painterResource(id = R.drawable.lomo_saltado),
                contentDescription = "Template",
                contentScale = ContentScale.Crop
            )*/

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(16.dp)),
                model = ImageRequest.Builder(context)
                    .data(dish.image)
                    .crossfade(2000)
                    .build(),
                contentDescription = "Template",
                contentScale = ContentScale.Crop
            )

            SpacerComponent(modifier = Modifier.height(12.dp))
            TextComponent(
                text = dish.name,
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
                text = "${dish.carbohydrates}",
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
                text = "$${dish.price}",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                    // color = PrimaryColor
                )
            )

            RatingBar(currentRating = dish.rating.toInt())
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
