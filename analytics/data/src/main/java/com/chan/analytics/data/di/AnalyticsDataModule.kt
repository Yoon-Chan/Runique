package com.chan.analytics.data.di

import com.chan.analytics.data.RoomAnalyticsRepository
import com.chan.analytics.domain.AnalyticsRepository
import com.example.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}