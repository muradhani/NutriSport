package com.example.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
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
     val EXTRA_SMALL = 10.sp
     val SMALL = 12.sp
     val REGULAR = 13.sp
     val EXTRA_REGULAR = 16.sp
     val MEDIUM = 18.sp
     val EXTRA_MEDIUM = 20.sp
     val LARGE = 30.sp
     val EXTRA_LARGE = 40.sp
}