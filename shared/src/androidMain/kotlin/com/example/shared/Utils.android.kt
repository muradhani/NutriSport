package com.example.shared

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

actual fun showToast(message: String, platformContext: Any?) {
    val context = platformContext as? Context ?: return
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
@Composable
actual fun rememberPlatformContext(): Any? {
    return LocalContext.current
}