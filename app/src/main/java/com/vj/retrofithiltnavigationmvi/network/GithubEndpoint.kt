package com.vj.retrofithiltnavigationmvi.network

import com.vj.retrofithiltnavigationmvi.model.RepoResponse
import com.vj.retrofithiltnavigationmvi.model.UserDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubEndpoint {

    @GET("users")
    suspend fun requestUserData(): ArrayList<RepoResponse>

    @GET("users/{userName}")
    suspend fun requestUserDetailsData(@Path("userName") userName:String): UserDetailsResponse

}