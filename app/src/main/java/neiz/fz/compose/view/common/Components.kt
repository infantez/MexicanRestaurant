package neiz.fz.compose.view.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import neiz.fz.compose.R
import neiz.fz.compose.ui.theme.PrimaryColor
import neiz.fz.compose.view.home.BottomNavigationItem

@Composable
fun BoxBackground() {
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
    }
}

@Composable
fun ImageComponent(
    modifier:Modifier = Modifier,
    @DrawableRes image:Int,
    description:String
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = description,
        modifier = modifier
    )
}

@Composable
fun TextComponent(
    modifier:Modifier = Modifier,
    text:String,
    style:TextStyle
) {
    Text(
        text = text,
        modifier = modifier,
        style = style
    )
}

@Composable
fun TextAnotationComponent(
    modifier:Modifier = Modifier,
    text:AnnotatedString,
    style:TextStyle
) {
    Text(
        text = text,
        modifier = modifier,
        style = style
    )
}

@Composable
fun SpacerComponent(
    modifier:Modifier = Modifier
) {
    Spacer(
        modifier = modifier
    )
}

@Composable
fun ButtonComponent(
    modifier:Modifier = Modifier,
    text:String,
    style:TextStyle,
    containerColor: Color,
    contentColor: Color,
    onClickButton: ()->Unit
) {
    Button(
        onClick = {
            onClickButton()
        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = contentColor,
            containerColor = containerColor
        )
    ) {
        Text(
            text = text
            ,style = style
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldComponents(
    modifier : Modifier = Modifier,
    text : String,
    cornerShapeDp : Dp,
    textLabel : String,
    style: TextStyle,
    colors : TextFieldColors,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon : @Composable (()->Unit) ? = null,
    onValuechange:(String)->Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            onValuechange(it)
        },
        shape = RoundedCornerShape(cornerShapeDp),
        label = {
            Text(
                text = textLabel,
                style = style
            )
        },
        colors = colors,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation
    )
}

@Composable
fun OutlinedButtonComponent(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    containerColor: Color,
    contentColor: Color,
    border: BorderStroke,
    onClickButton: () -> Unit
) {
    OutlinedButton(
        onClick = {
            onClickButton()
        },
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor,
            containerColor = containerColor
        ),
        border = border
    ) {
        Text(
            text = text,
            style = style
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    modifier:Modifier = Modifier,
    text:String,
    backgroundColor: Color = Color.White
) {
    CenterAlignedTopAppBar(
    // TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = text,
                style = TextStyle(
                    color = PrimaryColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = backgroundColor
        ),
        actions = {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notifications",
                tint = Color.Black
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu",
                tint = Color.Black
            )
        }
    )
}

@Composable
fun NavigationBarComponent(
    modifier: Modifier = Modifier,
    items:List<BottomNavigationItem>,
    onNavigationItem:(BottomNavigationItem)->Unit

) {
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    NavigationBar (
        modifier = modifier
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    onNavigationItem(item)
                },
                colors = NavigationBarItemDefaults.colors()
                , icon = {
                    Icon(
                        imageVector =
                        if(index == selectedItemIndex)
                            item.selectedIcon
                        else
                            item.unselectedIcon,
                        contentDescription = item.title,
                        tint =
                        if(index == selectedItemIndex)
                            PrimaryColor
                        else
                            Color.Black
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = TextStyle(
                            color =
                                if(index == selectedItemIndex)
                                    PrimaryColor
                                else
                                    Color.Black
                        )
                    )
                }
            )
        }
    }
}