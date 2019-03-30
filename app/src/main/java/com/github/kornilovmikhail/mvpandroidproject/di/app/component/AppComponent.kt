package com.github.kornilovmikhail.mvpandroidproject.di.app.component

import android.content.Context
import android.content.SharedPreferences
import com.github.kornilovmikhail.mvpandroidproject.data.local.dao.EventDao
import com.github.kornilovmikhail.mvpandroidproject.data.network.SpaceXAPI
import com.github.kornilovmikhail.mvpandroidproject.di.app.module.ContextModule
import com.github.kornilovmikhail.mvpandroidproject.di.app.module.DataDBModule
import com.github.kornilovmikhail.mvpandroidproject.di.app.module.DataNetModule
import com.github.kornilovmikhail.mvpandroidproject.di.app.module.SharedPreferencesModule
import com.github.kornilovmikhail.mvpandroidproject.di.app.scope.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [ContextModule::class, DataDBModule::class, DataNetModule::class, SharedPreferencesModule::class])
interface AppComponent {
    fun provideApp(): Context
    fun provideSpaceXApi(): SpaceXAPI
    fun provideEventDao(): EventDao
    fun provideSharedPreferences(): SharedPreferences
}
