package com.chan.analytics.domain

interface AnalyticsRepository {
    suspend fun getAnalyticsValue(): AnalyticsValue
}