package com.chan.analytics.domain

import kotlin.time.Duration

data class AnalyticsValue(
    val totalDistanceRun: Int = 0,
    val totalTimeRun: Duration = Duration.ZERO,
    val fastestEverRun: Double = 0.0,
    val avgDistanceRun: Double = 0.0,
    val avgPacePerRun: Double = 0.0
)
