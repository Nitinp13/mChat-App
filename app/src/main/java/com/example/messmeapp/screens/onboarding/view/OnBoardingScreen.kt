package com.example.messmeapp.screens.onboarding.view

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.messmeapp.R
import com.example.messmeapp.screens.main.MainActivity
import com.example.messmeapp.ui.theme.AppBlackColor
import com.example.messmeapp.ui.theme.AppTopContainerColor
import com.example.messmeapp.ui.theme.AppWhiteColor
import com.example.messmeapp.ui.theme.AppYellowColor
import com.example.messmeapp.ui.theme.ManRope
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

@Composable
fun OnBoardingScreen(mGoogleSignInClient : GoogleSignInClient) {

    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTopContainerColor)
            .background(
                Brush.linearGradient(
                    listOf(
                        AppTopContainerColor,
                        AppYellowColor,
                        AppYellowColor,
                        AppWhiteColor
                    )
                )
            )
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = {
                      /*TODO*/
                (context as Activity).startActivityForResult(mGoogleSignInClient.signInIntent, 2001)

            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            colors = ButtonDefaults.buttonColors(AppWhiteColor)
        ) {

//            if(Firebase.auth.currentUser == null){
//                val signInIntent = AuthUI.getInstance()
//                    .createSignInIntentBuilder()
////                    .setLogo(R.drawable.dhoni)
////                    .setAvailableProviders(
////                        listOf(
////                            AuthUI.IdpConfig.EmailBuilder().build(),
////                            AuthUI.IdpConfig.GoogleBuilder().build()
////                        )
////                    )
//                    .build()
//                signIn.launch(signInIntent)
//            }else{
//                context.startActivity(Intent(context, MainActivity::class.java))
//                (context as Activity).finish()
//            }

            Text(
                text = "Sign In With Google",
                modifier = Modifier.padding(bottom = 3.dp, top = 2.dp),
                fontSize = 18.sp, fontWeight = FontWeight.W600,
                style = ManRope.bodyMedium,
                color = AppBlackColor
            )


        }


    }
}