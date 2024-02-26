package com.example.messmeapp.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.messmeapp.screens.onboarding.OnboardingActivity
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

object Utils {

    fun getPhotoUrl(auth : FirebaseAuth) : String? {
        val user = auth.currentUser
        return user?.photoUrl?.toString()
    }

    fun getUserName(auth: FirebaseAuth) : String?{
        val user = auth.currentUser
        return if(user != null){
            return user.displayName
        }else{
            "ANONYMOUS"
        }
    }

    fun fireBaseSignOut(context : Context, auth : FirebaseAuth){
        AuthUI.getInstance().signOut(context)
        context.startActivity(Intent(context as Activity, OnboardingActivity::class.java))
        (context as Activity).finish()
    }
}