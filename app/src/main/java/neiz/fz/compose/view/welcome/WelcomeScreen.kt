package neiz.fz.compose.view.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import neiz.fz.compose.R
import neiz.fz.compose.ui.theme.Primary
import neiz.fz.compose.ui.theme.PrimaryColor
import neiz.fz.compose.view.common.BoxBackground
import neiz.fz.compose.view.common.ButtonComponent
import neiz.fz.compose.view.common.ImageComponent
import neiz.fz.compose.view.common.SpacerComponent
import neiz.fz.compose.view.common.TextComponent

@Composable
fun WelcomeScreen(onClick: () -> Unit) {

    BoxBackground()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            WelcomeHeader()
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), contentAlignment = Alignment.BottomCenter
        ) {
            WelcomeComponent(
                onClick = {
                    onClick()
                }
            )
        }
    }
}

@Composable
fun WelcomeHeader() {

    Column {
        ImageComponent(
            image = R.drawable.logo,
            description = stringResource(id = R.string.desc_logo),
            modifier = Modifier
                .fillMaxWidth()
                .size(150.dp)
        )


        SpacerComponent(modifier = Modifier.height(12.dp))

        TextComponent(
            text = stringResource(id = R.string.slogan),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Primary
            ), modifier = Modifier.fillMaxWidth()
        )
    }

}

@Composable
fun WelcomeComponent(onClick: () -> Unit) {

    ImageComponent(
        image = R.drawable.food,
        description = stringResource(id = R.string.desc_food),
        modifier = Modifier.fillMaxSize()
    )

    ButtonComponent(
        text = stringResource(id = R.string.start),
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),
        contentColor = Color.White,
        containerColor = PrimaryColor,
        modifier = Modifier
            .padding(bottom = 50.dp)
            .width(200.dp),
        onClickButton = {
            onClick()
        }
    )

}
