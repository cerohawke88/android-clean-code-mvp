package com.cerohawke88.cleanarchitecturemvp.network

import com.cerohawke88.cleanarchitecturemvp.data.Repo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkServices {

    @GET("repositories")
    fun getRepoTrending(@Query("language") language: String, @Query("since") since: String): Observable<List<Repo>>
}