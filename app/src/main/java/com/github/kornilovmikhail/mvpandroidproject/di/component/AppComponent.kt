package com.github.kornilovmikhail.mvpandroidproject.di.component

import android.content.Context
import com.github.kornilovmikhail.mvpandroidproject.di.module.ContextModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class])
interface AppComponent {
    fun provideApp(): Context
}
