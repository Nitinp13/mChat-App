package com.example.messmeapp.screens.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.messmeapp.R
import com.example.messmeapp.screens.main.datamodel.ChatDatamodel
import com.example.messmeapp.ui.theme.AppTopContainerColor
import com.example.messmeapp.ui.theme.AppWhiteColor

@Composable
fun MessageTextBox(chat : ChatDatamodel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp)
            .padding(horizontal = 20.dp)
            .then(
                if (chat.isOtherUser == true){
                    Modifier.padding(end = 90.dp)
                }else{
                    Modifier.padding(start = 90.dp)
                }
            )
            .clip(RoundedCornerShape(20.dp))

            .then(
                if (chat.isOtherUser == true){
                    Modifier.background(AppWhiteColor)
                }else{
                    Modifier.background(AppTopContainerColor)
                }
            )

            .padding(3.dp)


        ,
        horizontalArrangement = if (chat.isOtherUser == true) Arrangement.Start else Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = chat.mess ?: "NA",
            modifier = Modifier.padding(bottom = 5.dp, top = 5.dp, start = 10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.W600,
            fontFamily = FontFamily(Font(R.font.manrope_font)),
            color = if (chat.isOtherUser == true) Color.LightGray else Color.White,
            textAlign = if (chat.isOtherUser == true) TextAlign.Start else TextAlign.Start,
        )


    }
}