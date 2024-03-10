package neiz.fz.compose.course.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlusAndSubstractComponent() {

    // variables Mutables
    var name : String = "Nestor Infante"
    var price : Double = 20.8

    var nameActual = "Nestor Infante"

    name = "Nestor Eduardo Infante Zenteno"

    // variables Inmutables
    val pi : Double = 3.1416

    // COMPOSICIÓN: PINTAR TODOS LOS CONTROLES
    // ESTADO: quantity (valor a modificar)
    // EVENTO: OnClick
    // RECOMPOSICIÓN: Vuelve a pintar los controles que cambiaron

    var quantity by rememberSaveable {
        mutableStateOf(0)
    }
    
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(onClick = { quantity++ }) {
            Text(text = "+")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            // text = quantity.toString(),
            text = "$quantity",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = { quantity-- }) {
            Text(text = "-")
        }
    }

}
