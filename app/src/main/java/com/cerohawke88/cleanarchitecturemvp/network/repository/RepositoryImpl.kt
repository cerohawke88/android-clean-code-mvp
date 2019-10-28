package com.apps.data.repository

import com.cerohawke88.cleanarchitecturemvp.data.Repo
import com.cerohawke88.cleanarchitecturemvp.network.NetworkServices
import io.reactivex.Observable
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: NetworkServices
): Repository {

    override fun getRepoTrending(language:String,since:String): Observable<List<Repo>> {
        return service.getRepoTrending(language, since)
    }

}