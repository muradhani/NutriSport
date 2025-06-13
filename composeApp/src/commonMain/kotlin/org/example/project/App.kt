package org.example.project


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.example.navigation.setupNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        setupNavGraph()
    }
}