package com.nutrisport.auth.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shared.BebasNeueFontFamily
import com.example.shared.*
import com.mmk.kmpauth.firebase.google.GoogleButtonUiContainerFirebase


import com.nutrisport.auth.component.GoogleButton

@Composable
fun AuthScreen(){
    var loadingState by remember { mutableStateOf(false) }
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        containerColor = Surface
    ){ padding ->
        val context = rememberPlatformContext()
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
            GoogleButtonUiContainerFirebase(
                linkAccount = false,
                onResult = { result ->
                    result.onSuccess { user ->
                        loadingState = false

                    }.onFailure { error ->
                        var displayMessage = "An unknown error occurred."
                        if (error.message?.contains("A network error") == true){
                            displayMessage = "A network error occurred. Please check your connection."
                        }else if (error.message?.contains("Idtoken is null") == true){
                            displayMessage = "Sign in failed. Please try again."
                        }else{
                            displayMessage = "Sign in failed: ${error.message}"
                        }
                        showToast(displayMessage,context)
                        loadingState = false
                    }
                }
            ) {
                GoogleButton(
                    loading = false,
                    onClick = {
                        loadingState = true
                        this@GoogleButtonUiContainerFirebase.onClick()
                    }
                )
            }
        }
    }
}