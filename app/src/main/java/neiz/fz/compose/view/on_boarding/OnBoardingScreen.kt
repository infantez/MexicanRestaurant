package neiz.fz.compose.view.on_boarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import neiz.fz.compose.R
import neiz.fz.compose.ui.theme.PrimaryColor
import neiz.fz.compose.ui.theme.PrimaryText
import neiz.fz.compose.view.common.ImageComponent
import neiz.fz.compose.view.common.TextComponent

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    onClick:()->Unit
) {

    val pagerState = rememberPagerState()

    val pages = listOf(
        OnBoardingPage(
            image = R.drawable.image01,
            descImage = stringResource(id = R.string.img_explorer),
            title = stringResource(id = R.string.explorer),
            description = stringResource(id = R.string.desc_explorer)
        ),
        OnBoardingPage(
            image = R.drawable.image02,
            descImage = stringResource(id = R.string.img_discover),
            title = stringResource(id = R.string.discover),
            description = stringResource(id = R.string.desc_discover)
        ),
        OnBoardingPage(
            image = R.drawable.image03,
            descImage = stringResource(id = R.string.img_finder),
            title = stringResource(id = R.string.finder),
            description = stringResource(id = R.string.desc_finder)
        )
    )

    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = stringResource(id = R.string.desc_background),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize(),
            alpha = 0.2F
        )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f)
        ) { index ->
            PagerOnBoarding(pages[index])
        }

        Row(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            PagerFooter(pages, pagerState)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            FinishButtonComponent(
                modifier = Modifier.fillMaxWidth(),
                pagerState = pagerState,
                pages = pages,
                onClick = {
                    onClick()
                }
            )
        }
    }
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButtonComponent(
    modifier : Modifier = Modifier,
    pagerState: PagerState,
    pages: List<OnBoardingPage>,
    onClick:()->Unit
) {
    AnimatedVisibility(
        visible = pagerState.currentPage == pages.size -1
    ) {
        Button(
            modifier = modifier,
            onClick = {
                onClick()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor,
                contentColor = Color.White
            )
        ) {
            Text(
                text = stringResource(id = R.string.begin),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
            )
        }
    }

}

@Composable
fun PagerOnBoarding(onBoardingPage: OnBoardingPage) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ){

        ImageComponent(
            image = onBoardingPage.image,
            description = onBoardingPage.descImage,
            modifier = Modifier
                .fillMaxWidth(0.5f) // 50%
                .fillMaxHeight(0.7f) // 70%
        )

        TextComponent(
            text = onBoardingPage.title,
            style = TextStyle(
                color = PrimaryColor,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        )

        TextComponent(
            text = onBoardingPage.description,
            style = TextStyle(
                color = PrimaryText,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            ),
            modifier = Modifier
                .padding(top = 32.dp)
                .padding(horizontal = 24.dp)
        )
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerFooter(pages: List<OnBoardingPage>, pagerState: PagerState) {

    repeat(pages.size){interaction->
        val color = if(pagerState.currentPage == interaction) PrimaryColor else Color.LightGray
        Box(
            modifier = Modifier
                .padding(2.dp)
                .clip(CircleShape)
                .background(color)
                .size(10.dp)
        ) {

        }
    }

}
