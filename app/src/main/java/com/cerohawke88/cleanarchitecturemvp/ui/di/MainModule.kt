package com.cerohawke88.cleanarchitecturemvp.ui.di

import android.content.Context
import com.apps.data.repository.Repository
import com.apps.data.repository.RepositoryImpl
import com.cerohawke88.cleanarchitecturemvp.di.DataModule
import com.cerohawke88.cleanarchitecturemvp.di.DataScope
import com.cerohawke88.cleanarchitecturemvp.network.NetworkServices
import dagger.Module
import dagger.Provides

@Module(includes = [DataModule::class])
class MainModule(private val applicationContext: Context) {
    @AppScope @Provides
    fun provideRepository(@DataScope service: NetworkServices): Repository {
        return RepositoryImpl(service)
    }

    @Provides @AppScope
    fun provideContext(): Context {
        return applicationContext
    }
}