package com.example.finderly.Navigate

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.finderly.R
import com.example.finderly.Screen.FindMoreScreen
import com.example.finderly.Screen.LoginScreen
import com.example.finderly.Screen.MyPageScreen
import com.example.finderly.Screen.PostMoreScreen
import com.example.finderly.Screen.SignUpScreen
import com.example.finderly.Screen.SplashScreen
import com.example.finderly.mapScreen.MapScreenPage
import com.example.finderly.postScreen.MainBoardScreen
import com.example.finderly.postScreen.PostScreen
import com.example.finderly.postScreen.RegisterSreen
import com.example.finderly.searchScreen.LostItemInfoScreen
import com.example.finderly.searchScreen.RegisterLostItemScreen
import com.example.finderly.searchScreen.SearchScreen

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "LostPost/0/66643e471f0d524e5bbe7496"){
        // 로그인, 회원가입 페이지
        composable(route = "Splash") {
            SplashScreen(navController)
        }
        composable(route = "Login"){
            LoginScreen(navController)
        }
        composable(route = "Register") {
            SignUpScreen(navController)
        }

        // 메인 페이지
        composable("Search") {
            // 분실물 검색
            SearchScreen(navController)
        }
        composable("RegisterLost") {
            // 분실물 등록
            RegisterLostItemScreen(navController)
        }
        composable(
            route = "LostItemInfo/{lostId}",
            arguments = listOf(navArgument("lostId") { type = NavType.StringType })
        ) {
            // 분실물 상세 정보
            val lostId = it.arguments?.getString("lostId") ?: return@composable
            LostItemInfoScreen(lostId)
        }


        // 지도 페이지
        composable("Location") {
            // 지도 페이지
            MapScreenPage(navHostController = navController)
        }

        // 게시판 페이지
        composable(route = "PostBoard"){
            MainBoardScreen(navHostController = navController)
        }
        composable(
            route = "LostPost/{postCategory}/{postId}",
            arguments = listOf(navArgument("postCategory"){type = NavType.IntType},
                navArgument("postId"){type = NavType.StringType})
        ) {
            // 분실물 게시글 상세 페이지
            val postCategory = it.arguments?.getInt("postCategory")?: return@composable
            val postId = it.arguments?.getString("postId")?: return@composable
            PostScreen(navHostController = navController, R.string.lost_category, postCategory,postId)
        }
        composable(
            route = "FoundPost/{postCategory}/{postId}",
            arguments = listOf(navArgument("postCategory"){type = NavType.IntType},
                navArgument("postId"){type = NavType.StringType})) {
            // 습득물 게시글 상세 페이지
            val postCategory = it.arguments?.getInt("postCategory")?: return@composable
            val postId = it.arguments?.getString("postId")?: return@composable
            PostScreen(navHostController = navController, R.string.found_category, postCategory, postId)
        }
        composable("RegisterPost") {
            // 게시글 등록
            RegisterSreen(navHostController = navController)
        }

        // 마이 페이지
        composable(route = "MyPage") {
            MyPageScreen(navController)
        }
        composable(route = "FindMore") {
            FindMoreScreen(navController)
        }
        composable(route = "LostPostMore") {
            PostMoreScreen(navController,0)
        }
        composable(route = "FindPostMore") {
            PostMoreScreen(navController,1)
        }

    }
}