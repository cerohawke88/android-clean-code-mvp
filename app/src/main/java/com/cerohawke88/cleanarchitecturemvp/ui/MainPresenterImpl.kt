package com.cerohawke88.cleanarchitecturemvp.ui

import android.util.Log
import com.cerohawke88.cleanarchitecturemvp.data.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl(val interactor: MainInteractor, private var view: MainView?): MainPresenter{
    override fun setViewMain(mainView: MainView,language:String,since:String) {
        view = mainView
        getgetRepoTrendingGet(language,since)
    }

    private fun onGetFailure(e: Throwable?) {
        Log.e(e?.message, e?.stackTrace.toString())
        view?.showErrorRepo()
    }

    private fun getgetRepoTrendingGet(language:String,since:String){
        interactor.getRepoTrending(language,since)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { repoData ->  onGetMainResponseData(repoData)},
                { e -> onGetFailure(e) }
            )
    }

    private fun onGetMainResponseData(repoData: List<Repo>) {
        view?.showRepo(repoData)
    }
}