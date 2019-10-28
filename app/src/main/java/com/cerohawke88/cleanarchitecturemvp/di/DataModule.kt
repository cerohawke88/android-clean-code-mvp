package com.cerohawke88.cleanarchitecturemvp.di

import com.apps.network.Network.retrofitClient
import com.cerohawke88.cleanarchitecturemvp.network.NetworkServices
import dagger.Module
import dagger.Provides

@Module class DataModule {

    @Provides @DataScope
    fun provideServices(): NetworkServices {
        return retrofitClient().create(NetworkServices::class.java)
    }

}