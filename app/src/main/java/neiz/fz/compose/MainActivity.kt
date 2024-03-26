package neiz.fz.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import neiz.fz.compose.navigation.SetupNavGraph

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* GUARDAR ARCHIVO
        val preferences = getSharedPreferences("PREFERENCES_TOKEN", 0).edit()
        preferences.putString("KEY_TOKEN", "1234567890")
        preferences.apply()

        // Archivo guardado en: data/data/NOMBREPAQUETEAPP/shared_prefs
        */

        /* LEER ARCHIVO
        val preferencesRead = getSharedPreferences("PREFERENCES_TOKEN", 0)
        val token = preferencesRead.getString("KEY_TOKEN", "")
        */

        // Archivo guardado en: data/data/NOMBREPAQUETEAPP/shared_prefs

        setContent {
            SetupNavGraph()
        }
    }
}


