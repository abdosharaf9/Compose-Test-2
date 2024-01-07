package com.abdosharaf.composetest2.screens

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale


@Preview
@Composable
fun PermissionScreenPreview() {
    PermissionScreen {}
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionScreen(onPermissionGranted: () -> Unit) {
    val permissionState = rememberPermissionState(permission = Manifest.permission.READ_SMS)
    val context = LocalContext.current

    if (permissionState.status.isGranted) {
        onPermissionGranted()
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val text =
                if (permissionState.status.shouldShowRationale) "The app needs the SMS permission to function. Please grant the permission."
                else "You must grant the SMS permission from the application settings to use the application!"

            Text(
                text = text,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 24.dp)
            )

            if (permissionState.status.shouldShowRationale) {
                Button(onClick = { permissionState.launchPermissionRequest() }) {
                    Text(text = "Give The Permission")
                }
            } else {
                Button(onClick = {
                    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).also {
                        it.data = Uri.fromParts("package", context.packageName, null)
                        context.startActivity(it)
                    }
                }) {
                    Text(text = "Go To App Settings")
                }
            }
        }
    }
}