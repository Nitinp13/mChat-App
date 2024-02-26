package com.example.messmeapp.screens.main.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.messmeapp.R
import com.example.messmeapp.screens.main.datamodel.User
import com.example.messmeapp.ui.theme.AppBlackColor
import com.example.messmeapp.ui.theme.ManRope


@OptIn(ExperimentalTextApi::class)
@Composable
fun UserChatSummarized(user : User, index: Int, onClick: (() -> Unit)? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable {
                onClick?.invoke()
            }
    ) {

        AsyncImage(
            model = "https://picsum.photos/id/${index}/300/300",
//            painter = painterResource(id = user.image ?: R.drawable.dhoni),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(50.dp))
                .border(1.dp, Color.LightGray, RoundedCornerShape(50.dp))
            ,
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
        )


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 10.dp)
                .weight(1f)
            ,

        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 1.dp, top = 2.dp)
            ) {
//                Text(
//                    text = user.fName + " " + user.lName,
//                    modifier = Modifier.weight(1f) ,
//                    fontSize = 17.sp,
//                    letterSpacing = 0.8.sp,
//                    fontWeight = FontWeight.ExtraBold,
////                    fontFamily = FontFamily(Font(R.font.manrope_font)),
//                    overflow = TextOverflow.Ellipsis,
//                    color = Color.Black
//
//                    )
                Text(text = user.fName + " " + user.lName, modifier = Modifier.padding(bottom = 1.dp, top = 1.dp).weight(1f), fontSize = 17.sp, letterSpacing = 0.3.sp, fontWeight = FontWeight.W900, style = ManRope.bodySmall, color = AppBlackColor, overflow = TextOverflow.Ellipsis)
                
                Text(
                    text = user.lseen ?: "",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.W400,
                    letterSpacing = 0.8.sp,
                    fontFamily = FontFamily(Font(R.font.manrope_font)),
                    overflow = TextOverflow.Ellipsis,
                    color = AppBlackColor
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 1.dp)
            ) {
//                Text(
//                    text = user.lmess ?: "",
//                    modifier = Modifier.weight(1f),
//                    fontSize = 12.sp,
//                    fontWeight = FontWeight.W400,
//                    fontFamily = FontFamily(Font(R.font.manrope_font)),
//                    overflow = TextOverflow.Ellipsis,
//                    color = AppBlackColor
//                )
                Text(text = user.lmess ?: "", modifier = Modifier.padding(bottom = 3.dp, top = 1.dp).weight(1f), fontSize = 12.sp, fontWeight = FontWeight.W700, fontFamily = FontFamily(Font(R.font.manrope_font)), color = AppBlackColor, maxLines = 1, overflow = TextOverflow.Ellipsis,letterSpacing = 0.8.sp,)

                Image(painter = painterResource(id = R.drawable.double_tick), contentDescription = "",
                    modifier = Modifier
                        .padding(start = 35.dp)
                        .size(20.dp)
                        .background(Color.White, RoundedCornerShape(20.dp))
                )

            }

        }


    }
}