package com.example.finderly.searchScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finderly.R
import com.example.finderly.viewModel.LostViewModel
import com.example.finderly.viewModel.UserViewModel

@Composable
fun LostItemInfoScreen(lostId : String){
    val scrollstate = rememberScrollState()
    val userViewModel : UserViewModel = viewModel()
    val lostViewModel : LostViewModel = viewModel()
    Log.d("lostId","$lostId")

    LaunchedEffect(Unit) {
        userViewModel.lostitemInfo(lostId)
    }
    val lostitemInfo = userViewModel.lostiteminfo
    Log.d("lostitemInfo","$lostitemInfo")

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.lightgreen))) {
        Column(modifier = Modifier.padding(start = 25.dp, top = 15.dp)){
            Text(
                text = "Finderly",
                fontSize = 35.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.green)
            )
            Text(
                text = "분실물 상세정보",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.text_deepgreen)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 25.dp, top = 40.dp, end = 25.dp, bottom = 30.dp)
            .background(
                color = colorResource(
                    id = R.color.white
                ),
                shape = RoundedCornerShape(30.dp)
            )
            .padding(horizontal = 25.dp, vertical = 30.dp)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${lostitemInfo?.lostName}",
                    fontSize = 25.sp,
                    lineHeight = 25.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
                Spacer(modifier = Modifier.weight(1f))
                DeleteOrReportMenu(modifier = Modifier, deleteClick = {
                    if (lostitemInfo != null) {
                        lostViewModel.lostDelete(lostitemInfo.lostId)
                    }
                }, reportClick = {})
            }
            Spacer(modifier = Modifier.height(20.dp))
            Divider(
                color = colorResource(id = R.color.gray),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(2.dp)
            )
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollstate)
            ){
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Text(
                        text = "습득 위치",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.text_gray),
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = "${lostitemInfo?.lostLocation}",
                        fontSize = 15.sp,
                        color = colorResource(id = R.color.text_gray),
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Divider(
                    color = colorResource(id = R.color.gray),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(2.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Text(
                        text = "습득물",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.text_gray),
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(65.dp))
                    Text(
                        text = "${lostitemInfo?.lostName}",
                        fontSize = 15.sp,
                        color = colorResource(id = R.color.text_gray),
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Divider(
                    color = colorResource(id = R.color.gray),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(2.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Text(
                        text = "습득 날짜",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.text_gray),
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = "${lostitemInfo?.lostDate}",
                        fontSize = 15.sp,
                        color = colorResource(id = R.color.text_gray),
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Divider(
                    color = colorResource(id = R.color.gray),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(2.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Text(
                        text = "보관 장소",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.text_gray),
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = "${lostitemInfo?.storage}",
                        fontSize = 15.sp,
                        color = colorResource(id = R.color.text_gray),
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Divider(
                    color = colorResource(id = R.color.gray),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(2.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "상세 정보",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.text_gray),
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "${lostitemInfo?.description}",
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.text_gray),
                    fontWeight = FontWeight.Thin
                )
                Spacer(modifier = Modifier.height(5.dp))

                Divider(
                    color = colorResource(id = R.color.gray),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(2.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "사진",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.text_gray),
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(10.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                    items(10) {
                        Image(
                            painter = painterResource(id = R.drawable.lostitemexampleimage),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(20.dp)),
                            contentScale = ContentScale.Crop,

                            )
                    }
                }
            }
        }
    }
}