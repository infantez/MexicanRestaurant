package neiz.fz.compose.view.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import neiz.fz.compose.R
import neiz.fz.compose.ui.theme.PrimaryColor
import neiz.fz.compose.view.common.ButtonComponent
import neiz.fz.compose.view.common.ImageComponent
import neiz.fz.compose.view.common.OutlinedButtonComponent
import neiz.fz.compose.view.common.OutlinedTextFieldComponents
import neiz.fz.compose.view.common.SpacerComponent
import neiz.fz.compose.view.common.TextAnotationComponent
import neiz.fz.compose.view.common.TextComponent

@Composable
fun LoginScreen() {

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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                HeaderLogin()
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
                    .padding(start = 24.dp, end = 24.dp, top = 24.dp)
            ) {
                ContentLogin()
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FooterLogin()
            }
        }
    }

}

@Composable
fun HeaderLogin() {
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ImageComponent(
            image = R.drawable.logo,
            description = stringResource(id = R.string.desc_logo),
            modifier = Modifier
                .fillMaxWidth()
                .size(150.dp)
        )
    }

}

@Composable
fun ContentLogin() {

    TextComponent(
        text = stringResource(id = R.string.input_info),
        style = TextStyle(
            color = PrimaryColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    )

    OutlinedTextFieldComponents(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        text = "",
        cornerShapeDp = 12.dp,
        textLabel = stringResource(id = R.string.email),
        style = TextStyle(
            fontWeight = FontWeight.Normal
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = PrimaryColor,
            unfocusedBorderColor = Color.Black,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions (
            onNext = {}
        ),
        trailingIcon = {
            IconButton(onClick = { }) {
                Icon (
                    imageVector = Icons.Filled.Clear,
                    contentDescription = stringResource(id = R.string.desc_clear)
                )
            }
        }
    )

    OutlinedTextFieldComponents(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        text = "",
        cornerShapeDp = 12.dp,
        textLabel = stringResource(id = R.string.password),
        style = TextStyle(
            fontWeight = FontWeight.Normal
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = PrimaryColor,
            unfocusedBorderColor = Color.Black,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions (
            onDone = {

            }
        ),
        trailingIcon = {
            IconButton(onClick = { /*sTODO*/ }) {
                Icon (
                    imageVector = Icons.Filled.Visibility,
                    contentDescription = stringResource(id = R.string.desc_visible)
                )
            }
        },
        visualTransformation = PasswordVisualTransformation()
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        ButtonComponent(
            text = stringResource(id = R.string.enter),
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            containerColor = PrimaryColor,
            contentColor = Color.White,
            onClickButton = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )
    }



}

@Composable
fun FooterLogin() {

    TextAnotationComponent(
        text = buildAnnotatedString {
            append(stringResource(id = R.string.forget))
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = PrimaryColor)){
                append(stringResource(id = R.string.into))
            }
        },
        style = TextStyle(
            fontWeight = FontWeight.Normal
        )
    )

    SpacerComponent(modifier = Modifier.height(64.dp))

    TextComponent(
        text = stringResource(id = R.string.not_register),
        style = TextStyle(
            fontWeight = FontWeight.Normal
        )
    )

    SpacerComponent(modifier = Modifier.height(16.dp))

    OutlinedButtonComponent(
        text = stringResource(id = R.string.register),
        style = TextStyle(
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold
        ),
        containerColor = Color.White,
        contentColor = PrimaryColor,
        onClickButton = {

        },
        border = BorderStroke(
            width = 1.dp,
            color = PrimaryColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 24.dp)
    )



}
