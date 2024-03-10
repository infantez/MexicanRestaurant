package neiz.fz.compose.course.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SurverComponent() {

    // Estado: Curso seleccionado
    // Evento: onClick
    // Recomposición:

    val courses = listOf("Jetpack Compose", "SwiftUI", "Dart")

    var currentSelection by remember {
        mutableStateOf(courses.first())
    }

    Column {

        courses.forEach{course ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = course == currentSelection,
                    onClick = {
                        currentSelection = course
                    },
                    enabled = true,
                    colors = RadioButtonDefaults.colors(
                        selectedColor =  Color.Red,
                        unselectedColor = Color.Yellow,
                        // disabledSelectedColor = Color.Green,
                        disabledUnselectedColor = Color.Magenta
                    )
                )
                Text(text = course)
            }
        }
    }

}

@Preview( name = "Preview", showSystemUi = true)
@Composable
fun SurverComponentPreview() {
    SurverComponent()
}