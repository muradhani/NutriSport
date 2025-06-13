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

object FontSize {
    const val EXTRA_SMALL = 10
    const val SMALL = 12
    const val REGULAR = 13
    const val EXTRA_REGULAR = 16
    const val MEDIUM = 18
    const val EXTRA_MEDIUM = 20
    const val LARGE = 30
    const val EXTRA_LARGE = 40
}