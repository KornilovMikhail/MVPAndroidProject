package com.github.kornilovmikhail.mvpandroidproject.di.module

import com.github.kornilovmikhail.mvpandroidproject.data.Pagination
import com.github.kornilovmikhail.mvpandroidproject.data.repo.EventsDBRepo
import com.github.kornilovmikhail.mvpandroidproject.data.repo.EventsNetworkRepo
import com.github.kornilovmikhail.mvpandroidproject.data.repo.EventsRepo
import com.github.kornilovmikhail.mvpandroidproject.data.repo.TempEvents
import com.github.kornilovmikhail.mvpandroidproject.di.scope.EventScope
import dagger.Module
import dagger.Provides

@Module
class BaseModule {
    @Provides
    @EventScope
    fun provideEventsRepo(
        eventsDBRepo: EventsDBRepo,
        eventsNetworkRepo: EventsNetworkRepo,
        tempEvents: TempEvents
    ): EventsRepo = EventsRepo(eventsDBRepo, eventsNetworkRepo, tempEvents)

    @Provides
    @EventScope
    fun providePagination(): Pagination = Pagination()

    @Provides
    @EventScope
    fun provideTempEvents(): TempEvents = TempEvents
}
