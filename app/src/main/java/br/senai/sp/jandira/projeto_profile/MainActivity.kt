package br.senai.sp.jandira.projeto_profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.senai.sp.jandira.projeto_profile.screens.ProfileScreen
import br.senai.sp.jandira.projeto_profile.ui.theme.ProjetoProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoProfileTheme {
                ProfileScreen()
            }
        }
    }
}
