package com.cerohawke88.cleanarchitecturemvp.ui.di

import com.cerohawke88.cleanarchitecturemvp.ui.MainActivity
import dagger.Component

@AppScope
@Component(modules = [
    MainModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}