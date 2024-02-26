package com.example.messmeapp.screens.main.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.messmeapp.R
import com.example.messmeapp.screens.main.datamodel.ChatDatamodel
import com.example.messmeapp.screens.main.datamodel.User
import com.example.messmeapp.ui.theme.AppTopContainerColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun UserChatScreen(
    openUserChatScreen : MutableState<Boolean>,
    user : User?
) {

    val modalSheet = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = {
            coroutineScope.launch(Dispatchers.IO) {
                openUserChatScreen.value = false
            }
         },
        sheetState = modalSheet,
        dragHandle = {
            BottomSheetDefaults.DragHandle(
                color = AppTopContainerColor,
            )
        },
        containerColor = AppTopContainerColor,
        modifier = Modifier
            .fillMaxSize()
//            .background(AppTopContainerColor)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
//            .background(Color.White)
                .background(color = AppTopContainerColor)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                //            Box(modifier = Modifier.size(40.dp).clip(RoundedCornerShape(20.dp)).background(Color.White).border(2.dp, Color.Gray)) {
                Image(painter = painterResource(id = R.drawable.arrow_back_24), contentDescription = "", modifier = Modifier
                    .size(50.dp)
//                    .clip(RoundedCornerShape(20.dp))
//                    .border(2.dp, Color.Gray, RoundedCornerShape(20.dp))
                    .padding(8.dp)
                    .clickable {
                        coroutineScope.launch(Dispatchers.IO) {
                            modalSheet.hide()
                            openUserChatScreen.value = false
                        }
                    }
                    ,
                    colorFilter = ColorFilter.tint(Color.White)
                )
//            }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = user?.fName + " " + user?.lName, modifier = Modifier.padding(bottom = 1.dp, top = 1.dp), fontSize = 18.sp, fontWeight = FontWeight.W600, fontFamily = FontFamily(
                        Font(R.font.manrope_font)
                    ), color = Color.White)
                    Row(
                        modifier = Modifier.padding(bottom = 2.dp, top = 1.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(painter = painterResource(id = R.drawable.circle_status_24), contentDescription = "", modifier = Modifier
                            .size(10.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.Green)
                            .padding(end = 2.dp)
//                    .border(2.dp, Color.Gray, RoundedCornerShape(20.dp))
//                            .padding(8.dp)
                            ,
                            colorFilter = ColorFilter.tint(Color.Green)
                        )

                        Text(text = "Online",  fontSize = 12.sp, fontWeight = FontWeight.W700, fontFamily = FontFamily(
                            Font(R.font.manrope_font)
                        ), color = Color.LightGray, modifier = Modifier.padding(start = 5.dp))
                    }


                }

//            Box(modifier = Modifier.size(40.dp).clip(RoundedCornerShape(20.dp)).background(Color.White).border(2.dp, Color.Gray)) {
                Image(painter = painterResource(id = R.drawable.more_horiz_24), contentDescription = "", modifier = Modifier
                    .size(50.dp)
//                    .clip(RoundedCornerShape(20.dp))
//                    .border(2.dp, Color.Gray, RoundedCornerShape(20.dp))
                    .padding(8.dp)
                    ,
                    colorFilter = ColorFilter.tint(Color.White)
                )
//            }






            }

            val chatList = ArrayList<ChatDatamodel>().apply {
                add(ChatDatamodel( mess = "I want to be the captain of the team", isOtherUser = false))
                add(ChatDatamodel(mess =  "Hey, it's been a while since we've hang out after school", isOtherUser = true))
                add(ChatDatamodel( mess = "I want to be the captain of the team", isOtherUser = false))
                add(ChatDatamodel(mess =  "Hey, it's been a while since we've hang out after school", isOtherUser = true))
                add(ChatDatamodel( mess = "I want to be the captain of the team", isOtherUser = false))
                add(ChatDatamodel(mess =  "Hey, it's been a while since we've hang out after school", isOtherUser = true))
                add(ChatDatamodel( mess = "I want to be the captain of the team", isOtherUser = false))
                add(ChatDatamodel(mess =  "Hey, it's been a while since we've hang out after school", isOtherUser = true))
                add(ChatDatamodel( mess = "I want to be the captain of the team", isOtherUser = false))
                add(ChatDatamodel(mess =  "Hey, it's been a while since we've hang out after school", isOtherUser = true))
                add(ChatDatamodel( mess = "I want to be the captain of the team", isOtherUser = false))
                add(ChatDatamodel(mess =  "Hey, it's been a while since we've hang out after school", isOtherUser = true))
                add(ChatDatamodel( mess = "I want to be the captain of the team", isOtherUser = false))
                add(ChatDatamodel(mess =  "Hey, it's been a while since we've hang out after school", isOtherUser = true))
                add(ChatDatamodel( mess = "I want to be the captain of the team", isOtherUser = false))
                add(ChatDatamodel(mess =  "Hey, it's been a while since we've hang out after school", isOtherUser = true))
            }

//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
//                    .background(color = Color.White)
//                    .verticalScroll(rememberScrollState())
//            ){
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                        .background(color = Color.White)
                        .heightIn(max = 9000.dp)
//                        .height(getScreenHeight(target = 1.6f))
//                    .padding(top = 60.dp)
                    ,
                    content = {

//                    stickyHeader {
//                        Text(text = "All Messages", modifier = Modifier
//                            .fillMaxWidth()
//                            .background(Color.White)
//                            .padding(horizontal = 10.dp), fontSize = 19.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle(R.font.manrope_font)
//                        )
//                    }

                        itemsIndexed(chatList){
                                index, item ->
                            MessageTextBox(chat = item)
                        }
                    })
//            }

        }





    }

    BackHandler {
        coroutineScope.launch(Dispatchers.IO) {
            openUserChatScreen.value = false
        }
    }
}

@Composable
fun getScreenHeight(target: Float): Dp {
    val configuration = LocalConfiguration.current
    val screenHeightPixels = configuration.screenHeightDp
    val density = LocalDensity.current.density
    val screenHeightDp = screenHeightPixels.dp / density
    return (target * screenHeightDp)
}