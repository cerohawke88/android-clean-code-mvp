package com.cerohawke88.cleanarchitecturemvp.ui

import com.cerohawke88.cleanarchitecturemvp.data.Repo

interface MainView {
    fun showRepo(data: List<Repo>)
    fun showErrorRepo()
}