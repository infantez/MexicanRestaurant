package neiz.fz.compose.course.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextComponent() {

    // Estado: mytext
    // Evento: onValueChange
    // Recomposición

    var myText by remember {
        mutableStateOf("")
    }

    Column {
       OutlinedTextField(
           value = myText,
           onValueChange = { // text ->
               myText = it
           }
       )

        Text(
            text = myText
        )
    }

}

@Preview( name = "Preview", showSystemUi = true)
@Composable
fun TextComponentPreview() {
    TextComponent()
}

@Composable
fun VisibilityComponent() {

    //Estado: visibility : Boolean
    //Evento: onClick
    //Recomposición:

    var visibility by remember {
        mutableStateOf(false) // true: mostra // false: ocultar
    }

    Row {
        Button(
            onClick = { visibility = true }
        ) {
            Text(text = "Visible")
        }

        Button(
            onClick = { visibility = false }
        ) {
            Text(text = "Invisible")
        }

        if(visibility){
            Text(text = "MitoCode")
        }

    }
}

@Preview( name = "Preview2", showSystemUi = true)
@Composable
fun Preview() {
    VisibilityComponent()
}

