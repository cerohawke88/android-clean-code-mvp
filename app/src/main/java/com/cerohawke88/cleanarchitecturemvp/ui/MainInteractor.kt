package com.cerohawke88.cleanarchitecturemvp.ui

import com.cerohawke88.cleanarchitecturemvp.data.Repo
import io.reactivex.Observable

interface MainInteractor {
    fun getRepoTrending(language:String,since:String): Observable<List<Repo>>
}