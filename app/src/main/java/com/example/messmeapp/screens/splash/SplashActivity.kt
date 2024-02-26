package com.example.messmeapp.screens.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.example.messmeapp.R
import com.example.messmeapp.backend.preferences.AppPreference
import com.example.messmeapp.backend.preferences.PrefUtils
import com.example.messmeapp.screens.main.MainActivity
import com.example.messmeapp.screens.onboarding.OnboardingActivity
import com.example.messmeapp.screens.onboarding.view.OnBoardingScreen
import com.example.messmeapp.ui.theme.AppTopContainerColor
import com.example.messmeapp.ui.theme.MessMeAppTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SplashActivity : ComponentActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableFullScreen()
        auth =  Firebase.auth

        setContent {
            SideEffect {
                window.statusBarColor = AppTopContainerColor.toArgb()
            }
            MessMeAppTheme {
               val intent =
                   if (auth.currentUser == null){
//                   if (PrefUtils.getBoolean(LocalContext.current, AppPreference.IS_ONBOARDING_VISITED, false)){
                    Intent(this, OnboardingActivity::class.java)
                }else{
                    Intent(this, MainActivity::class.java)
                }
                    startActivity(intent)
                    finish()
            }
        }

    }

    private fun enableFullScreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}