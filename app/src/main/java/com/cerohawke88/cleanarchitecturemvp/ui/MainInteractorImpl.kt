package com.cerohawke88.cleanarchitecturemvp.ui

import com.cerohawke88.cleanarchitecturemvp.data.Repo
import com.cerohawke88.cleanarchitecturemvp.network.NetworkServices
import io.reactivex.Observable

class MainInteractorImpl(private val service: NetworkServices): MainInteractor{
    override fun getRepoTrending(language:String,since:String): Observable<List<Repo>> {
        return service.getRepoTrending(language,since)
    }
}