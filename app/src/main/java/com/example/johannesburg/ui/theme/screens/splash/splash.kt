package com.example.johannesburg.ui.theme.screens.splash


import android.net.Uri

import android.os.Bundle

import android.widget.VideoView

import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.viewinterop.AndroidView

import androidx.core.content.res.ResourcesCompat

import androidx.lifecycle.lifecycleScope



import kotlinx.coroutines.delay

import kotlinx.coroutines.launch

import android.content.Intent

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview

import com.example.johannesburg.R
import com.example.johannesburg.ui.theme.screens.login.LoginActivity

import com.example.johannesburg.ui.theme.screens.registration.RegisterActivity





class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            SplashScreen {

                startActivity(Intent(this, LoginActivity::class.java))

                finish()

            }

        }

    }

}



@Composable

fun SplashScreen(onVideoEnd: () -> Unit) {

    val context = LocalContext.current



    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        AndroidView(factory = { ctx ->

            VideoView(ctx).apply {

                setVideoURI(Uri.parse("android.resource://${context.packageName}/${R.raw.splash_screen}"))

                setOnCompletionListener { onVideoEnd() }

                start()

            }

        })

    }

}



@Preview

@Composable

fun PreviewSplashScreen() {

    SplashScreen(

        onVideoEnd = TODO()

    )

}

