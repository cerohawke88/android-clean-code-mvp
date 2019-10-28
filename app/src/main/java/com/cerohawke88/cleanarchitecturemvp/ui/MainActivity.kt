package com.cerohawke88.cleanarchitecturemvp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.cerohawke88.cleanarchitecturemvp.R
import com.cerohawke88.cleanarchitecturemvp.data.Repo
import com.cerohawke88.cleanarchitecturemvp.ui.di.DaggerAppComponent
import com.cerohawke88.cleanarchitecturemvp.ui.di.MainModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),MainView {
    override fun showRepo(data: List<Repo>) {
        uiText.visibility = View.GONE
        listRepo.visibility = View.VISIBLE
        listRepo.adapter = MainAdapter(data)
        uiSwipe.setRefreshing(false)
    }

    override fun showErrorRepo() {
        uiText.visibility = View.VISIBLE
    }

    @Inject
    lateinit var presenter: MainPresenter
    var mContext = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.builder()
            .mainModule(MainModule(getApplicationContext()))
            .build()
            .inject(this)
        uiText.visibility = View.GONE
        uiSwipe.setRefreshing(true)
        listRepo.setLayoutManager(LinearLayoutManager(this))
        presenter.setViewMain(this,"","daily")
        uiSwipe.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            presenter.setViewMain(mContext,"","daily")
        })
    }
}
