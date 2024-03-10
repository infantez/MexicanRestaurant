package neiz.fz.compose.course.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun First_components(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(
            text = "Mitocode 2024",
            fontSize = 24.sp,
            color = Color.White,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                // En los Modifier SI importa el orden, en los atributos NO
                // SP = Scalar por pixel (Para texto)
                // DP = Densidad por pixel
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Color.Black
                )
                .background(Color.Blue)
                .padding(8.dp)
        )

        Text(
            text = "Teacher: Juan José Ledesma"
        )

        Text(
            text = "Student: Nestor Eduardo Infante Zenteno"
        )

        // ESTADO: text
        // EVENTO: onValueChange
        // RECOMPOSICIÓN


        var text by rememberSaveable {
            mutableStateOf("")
        }

        var text2 by rememberSaveable {
            mutableStateOf("")
        }

        TextField(
            value = text,
            onValueChange = {
                text = it
            }
        )
        OutlinedTextField(
            value = text2,
            onValueChange = {
                text2 = it
            }
        )

        Text(text = text)
        Text(text = text2)
    }
}


@Preview(name = "Preview 1", showSystemUi = true)
@Composable
fun First_componentsPreview(){
    First_components()
}
