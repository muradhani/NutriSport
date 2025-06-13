package com.example.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import nutrisport.shared.generated.resources.BebasNeue_Regular
import nutrisport.shared.generated.resources.Res
import nutrisport.shared.generated.resources.RobotoCondensed_Medium
import org.jetbrains.compose.resources.Font


@Composable
fun BebasNeueFontFamily () = FontFamily(
    Font(Res.font.BebasNeue_Regular)
)

@Composable
fun RobotoCondensedFontFamily () = FontFamily(
    Font(Res.font.RobotoCondensed_Medium)
)