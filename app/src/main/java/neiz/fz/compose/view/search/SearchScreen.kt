package neiz.fz.compose.view.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import neiz.fz.compose.view.common.BoxBackground

@Composable
fun SearchScreen(paddingValues: PaddingValues) {

    BoxBackground()

    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)

    ){
        Text(text = "Search")
    }

}