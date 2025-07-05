package com.example.shared

import androidx.compose.runtime.Composable

expect fun showToast(message: String, platformContext: Any? = null)

@Composable
expect fun rememberPlatformContext(): Any?
