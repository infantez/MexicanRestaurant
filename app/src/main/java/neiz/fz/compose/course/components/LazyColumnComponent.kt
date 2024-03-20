package neiz.fz.compose.course.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import neiz.fz.compose.ui.theme.PrimaryColor
import androidx.compose.foundation.lazy.LazyColumn

@Composable
fun LazyColumnComponent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(10) {
            // Text(text = "El contador es $it")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {

                    },
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PrimaryColor
                )
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "El contador es $it",
                    color = Color.White
                )
            }
        }
    }
}