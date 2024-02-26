package com.example.messmeapp.screens.main.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.messmeapp.R
import com.example.messmeapp.screens.main.datamodel.User
import com.example.messmeapp.screens.onboarding.OnboardingActivity
import com.example.messmeapp.ui.theme.AppTopContainerColor
import com.example.messmeapp.utils.Utils.getUserName
import com.firebase.ui.auth.AuthUI
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(Color.White)
            .background(color = AppTopContainerColor)
            .padding(top = 10.dp)
    ) {

        val messageList = ArrayList<User>().apply {
            add(User(fName = "Rohit", lName = "Sharma", image = R.drawable.dhoni, lmess = "Let me be the Caption", lseen = "10:00 AM"))
            add(User(fName = "Philip", lName = "Franci", image = R.drawable.dhoni, lmess = "Hey, it's been a while since we've hang out after school", lseen = "2:00 PM"))
            add(User(fName = "Sachin", lName = "Tendulkar", image = R.drawable.dhoni, lmess = "I dont like Shubman Gill", lseen = "7:00 PM"))
            add(User(fName = "Rohit", lName = "Sharma", image = R.drawable.dhoni, lmess = "Let me be the Caption", lseen = "10:00 AM"))
            add(User(fName = "Virat", lName = "Kohli", image = R.drawable.dhoni, lmess = "will make a century today!!", lseen = "2:00 PM"))
            add(User(fName = "Sachin", lName = "Tendulkar", image = R.drawable.dhoni, lmess = "I dont like Shubman Gill", lseen = "7:00 PM"))
            add(User(fName = "Rohit", lName = "Sharma", image = R.drawable.dhoni, lmess = "Let me be the Caption", lseen = "10:00 AM"))
            add(User(fName = "Virat", lName = "Kohli", image = R.drawable.dhoni, lmess = "will make a century today!!", lseen = "2:00 PM"))
            add(User(fName = "Sachin", lName = "Tendulkar", image = R.drawable.dhoni, lmess = "I dont like Shubman Gill", lseen = "7:00 PM"))
            add(User(fName = "Rohit", lName = "Sharma", image = R.drawable.dhoni, lmess = "Let me be the Caption", lseen = "10:00 AM"))
            add(User(fName = "Virat", lName = "Kohli", image = R.drawable.dhoni, lmess = "will make a century today!!", lseen = "2:00 PM"))
            add(User(fName = "Sachin", lName = "Tendulkar", image = R.drawable.dhoni, lmess = "I dont like Shubman Gill", lseen = "7:00 PM"))
        }

        Row(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            val openUserInfoScreen = remember {
                mutableStateOf(false)
            }

            if (openUserInfoScreen.value){
                UserInfoScreen(openUserInfoScreen)
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hi, ${getUserName(Firebase.auth)}!", modifier = Modifier.padding(bottom = 3.dp, top = 2.dp), fontSize = 12.sp, fontWeight = FontWeight.W700, fontFamily = FontFamily(Font(R.font.manrope_font)), color = Color.LightGray)
                Text(text = "You Received", modifier = Modifier.padding(bottom = 3.dp, top = 2.dp), fontSize = 18.sp, fontWeight = FontWeight.W600, fontFamily = FontFamily(Font(R.font.manrope_font)), color = Color.White)
                Text(text = "48 Messages", modifier = Modifier.padding(bottom = 3.dp, top = 2.dp), fontSize = 23.sp, fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily(Font(R.font.manrope_font)), color = Color.White, textDecoration = TextDecoration.Underline)
            }
//            Box(modifier = Modifier.size(40.dp).clip(RoundedCornerShape(20.dp)).background(Color.White).border(2.dp, Color.Gray)) {
                Image(painter = painterResource(id = R.drawable.more_menu), contentDescription = "", modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        openUserInfoScreen.value = !openUserInfoScreen.value
                    }
                    .clip(RoundedCornerShape(20.dp))
                    .border(2.dp, Color.Gray, RoundedCornerShape(20.dp))
                    .padding(8.dp)
                    ,
                    colorFilter = ColorFilter.tint(Color.White))
//            }




        }


        val openUserChatScreen = remember {
            mutableStateOf(false)
        }

        val userChatScreen : MutableState<User?> = remember {
            mutableStateOf(null)
        }

        if (openUserChatScreen.value) {
            if (userChatScreen.value != null) {
                UserChatScreen(openUserChatScreen, userChatScreen.value)
            }else{
                openUserChatScreen.value = !openUserChatScreen.value
            }
        }

//        Box(modifier = Modifier
//            .background(Color.Transparent)
//            .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))){
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(color = Color.White)
                    .padding(top = 60.dp)
            ) {

                stickyHeader {
                    Text(
                        text = "All Messages",
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(horizontal = 10.dp),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle(R.font.manrope_font)
                    )
                }

                messageList.forEachIndexed { index, it ->
                    item {
                        UserChatSummarized(user = it, index) {
                            userChatScreen.value = it
                            openUserChatScreen.value = !openUserChatScreen.value
                        }
                    }
                }
            }
//        }




    }
}

