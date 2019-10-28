package com.apps.data.repository

import com.cerohawke88.cleanarchitecturemvp.data.Repo
import io.reactivex.Observable

interface Repository {
    fun getRepoTrending(language:String,since:String): Observable<List<Repo>>
}