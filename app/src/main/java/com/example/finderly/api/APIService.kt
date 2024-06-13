package com.example.finderly.api

import com.example.finderly.Data.LostItemInfoResponse
import com.example.finderly.Data.MyResponse
import com.example.finderly.Data.Post
import com.example.finderly.Data.PostItemInfoResponse
import com.example.finderly.Data.PostListItem
import com.example.finderly.Data.PostRequest
import com.example.finderly.Data.Response
import com.example.finderly.Data.SignUpRequest
import com.example.finderly.Data.UserResponse
import com.example.finderly.Data.registerResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIService {
    // comment 댓글

    // lost 분실물
    @GET("/lost/detail") // 분실물 상세 조회
    suspend fun getLostItemInfo(
        @Query("lostId") lostId: String
    ): LostItemInfoResponse

    // post 게시글
    @GET("/post/detail") // 게시글 상세 조회
    suspend fun getPostItemInfo(
        @Query("postCategory") postCategory: Int,
        @Query("postId") postId: String
    ): PostItemInfoResponse

    // 게시글 리스트 조회
    @GET("/post")
    suspend fun getPostList(
        @Query("postCategory") postCategory: Int
    ):List<PostListItem>
    
    // 게시글 등록하기
    @POST("/post/register")
    suspend fun registerPost(@Body postRequest: PostRequest): registerResponse

    // 게시글 상세 조회
    @GET("/post/detail")
    suspend fun getPostDetailInfo(
        @Query("postCategory") postCategory: Int,
        @Query("postId") postId: String
    ): Post

    // 게시글 삭제하기
    @DELETE("/post")
    suspend fun deletePost(
        @Query("postCategory") postCategory:Int,
        @Query("postId") postId:String
    ): Response

    // 게시글 검색
    @GET("/post/search")
    suspend fun searchPostByTitle(
        @Query("postCategory") postCategory: Int,
        @Query("keyword") keyword: String
    ):List<PostListItem>

    // report 신고

    // user 사용자
    @GET("/user/login") // 로그인
    suspend fun getLogin(
        @Query("userId") userId: String,
        @Query("userPassword") userPassword: String
    ): UserResponse

    @POST("/user/signup") // 회원가입
    suspend fun postSignUp(
        @Body SignUpRequest: SignUpRequest
    ) : UserResponse

    @GET("/user/profile") // 마이페이지 조회
    suspend fun getProfile(
        @Query("userId") userId: String
    ) : MyResponse

//    @GET("/user/logout") // 로그아웃
//    suspend fun getLogout(
//        @Query("userId") userId: String
//    ): UserResponse
}