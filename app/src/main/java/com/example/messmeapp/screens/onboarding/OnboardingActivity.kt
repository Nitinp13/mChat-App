package com.example.messmeapp.screens.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.example.messmeapp.R
import com.example.messmeapp.backend.preferences.AppPreference
import com.example.messmeapp.backend.preferences.PrefUtils
import com.example.messmeapp.screens.main.MainActivity
import com.example.messmeapp.screens.onboarding.view.OnBoardingScreen
import com.example.messmeapp.ui.theme.AppTopContainerColor
import com.example.messmeapp.ui.theme.MessMeAppTheme
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth

class OnboardingActivity : ComponentActivity() {

    private lateinit var auth : FirebaseAuth

//    val signIn : ActivityResultLauncher<Intent> = registerForActivityResult(FirebaseAuthUIActivityResultContract(), this::onSignInResult)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableFullScreen()
        auth = Firebase.auth
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(com.firebase.ui.auth.R.string.default_web_client_id))
            .requestEmail()
            .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        setContent {
            SideEffect {
                window.statusBarColor = AppTopContainerColor.toArgb()
            }

            MessMeAppTheme {
                if (auth.currentUser != null){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    OnBoardingScreen(mGoogleSignInClient)
                }

            }

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2001){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                account.idToken?.let { firebaseAuthWithGoogle(it) }
            }catch (e : Exception){
                Toast.makeText(this, "Login Failed, Please try Again Later", Toast.LENGTH_LONG).show()
                e.printStackTrace()
            }
        }

    }

    fun firebaseAuthWithGoogle(idToken : String){
        val credential = GoogleAuthProvider.getCredential(idToken,null)
        Firebase.auth.signInWithCredential(credential)
            .addOnCompleteListener(this) {task ->
                if (task.isSuccessful){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this, "Login Access Failed, Please try Again Later", Toast.LENGTH_LONG).show()

                }

            }
    }

//    fun onSignInResult(result : FirebaseAuthUIAuthenticationResult){
//        if(result.resultCode == RESULT_OK){
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }else{
//            Toast.makeText(this, "There was an error signing in, Please try Again Later", Toast.LENGTH_LONG).show()
//        }
//    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun enableFullScreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}