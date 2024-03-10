package neiz.fz.compose.course.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import neiz.fz.compose.R

@Composable
fun WelcomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.parseColor("#073042"))),
        verticalArrangement = Arrangement.SpaceEvenly

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val rainbowColorsBrush = remember {
                Brush.sweepGradient(
                    listOf(
                        Color(0xFF9575CD),
                        Color(0xFFBA68C8),
                        Color(0xFFE57373),
                        Color(0xFFFFB74D),
                        Color(0xFFFFF176),
                        Color(0xFFAED581),
                        Color(0xFF4DD0E1),
                        Color(0xFF9575CD)
                    )
                )
            }
            val borderWidth = 3.dp
            Image(
                painter = painterResource(id = R.drawable.info),
                contentDescription = "Account image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(170.dp)
                    .border(
                        BorderStroke(borderWidth, rainbowColorsBrush),
                        CircleShape
                    )
                    .padding(borderWidth)
                    .clip(CircleShape)
            )

            Text(
                text = "Nestor Infante",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = "Android Developer",
                color = Color(android.graphics.Color.parseColor("#3ddc84")),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )


        }


        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
        ) {

            Divider(
                thickness = 1.dp,
                color = Color.White
            )

            Row(
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Phone",
                    tint = Color(android.graphics.Color.parseColor("#3ddc84")),
                )

                Spacer(
                    modifier = Modifier
                        .width(12.dp)
                )

                Text(
                    text = "+52 331 094 7905",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Divider(
                thickness = 1.dp,
                color = Color.White
            )

            Row(
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Share",
                    tint = Color(android.graphics.Color.parseColor("#3ddc84")),
                )

                Spacer(
                    modifier = Modifier
                        .width(12.dp)
                )

                Text(
                    text = "@github.com/infantez",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Divider(
                thickness = 1.dp,
                color = Color.White
            )

            Row(
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email",
                    tint = Color(android.graphics.Color.parseColor("#3ddc84")),
                )

                Spacer(
                    modifier = Modifier
                        .width(12.dp)
                )

                Text(
                    text = "nestor_infante@hotmail.com",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

        }

    }
}
/*
@Preview(name = "Preview", showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}
*/
