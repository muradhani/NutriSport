package com.example.shared

import androidx.compose.runtime.Composable
import platform.UIKit.UIAlertControllerStyleAlert

import platform.UIKit.*
import platform.Foundation.*

actual fun showToast(message: String, platformContext: Any?) {
    val alert = UIAlertController.alertControllerWithTitle(
        title = null,
        message = message,
        preferredStyle = UIAlertControllerStyleAlert
    )

    alert.addAction(
        UIAlertAction.actionWithTitle(
            title = "OK",
            style = UIAlertActionStyleDefault,
            handler = null
        )
    )

    val rootVC = UIApplication.sharedApplication.keyWindow?.rootViewController
    rootVC?.presentViewController(alert, animated = true, completion = null)
}

@Composable
actual fun rememberPlatformContext(): Any? {
    return null
}