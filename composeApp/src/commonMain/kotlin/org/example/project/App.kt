package org.example.project


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.navigation.setupNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.mmk.kmpauth.google.*

@Composable
@Preview
fun App() {
    MaterialTheme {
        var appReady by remember { mutableStateOf(false) }
        LaunchedEffect(Unit){
            val WEB_CLIENT_ID = "924953097461-2ba5tr8gfbem5vb0umhngl0lg2lg9r51.apps.googleusercontent.com"
            GoogleAuthProvider.create(credentials = GoogleAuthCredentials(serverId = WEB_CLIENT_ID))
            appReady = true
        }
        AnimatedVisibility(
            modifier = Modifier.fillMaxSize(),
            visible = appReady
        ) {
            setupNavGraph()
        }
    }
}