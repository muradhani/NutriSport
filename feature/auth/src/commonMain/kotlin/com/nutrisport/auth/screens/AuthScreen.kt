package com.nutrisport.auth.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shared.Alpha
import com.example.shared.BebasNeueFontFamily
import com.example.shared.Black
import com.example.shared.FontSize
import com.example.shared.Orange
import com.example.shared.Surface
import com.nutrisport.auth.component.GoogleButton

@Composable
fun AuthScreen(){
    print("hello murad")
    print(BebasNeueFontFamily())
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        containerColor = Surface
    ){ padding ->
        Column (
            modifier = Modifier.padding(
                top = padding.calculateTopPadding(),
                bottom = padding.calculateBottomPadding()
            ).fillMaxSize().padding(horizontal = 20.dp)
        ){
            Column(
                modifier = Modifier.fillMaxWidth().weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "NUTRISPORT",
                    textAlign = TextAlign.Center,
                    fontFamily = BebasNeueFontFamily(),
                    fontSize = FontSize.EXTRA_LARGE,
                    fontWeight = FontWeight.Normal,
                    color = Orange
                )
                Text(
                    modifier = Modifier.fillMaxWidth().alpha(Alpha.HALF),
                    text = "Sign in to continue",
                    textAlign = TextAlign.Center,
                    fontSize = FontSize.EXTRA_REGULAR,
                    color = Black
                )
            }
            GoogleButton(
                loading = false,
                onClick = { }
            )
        }
    }
}