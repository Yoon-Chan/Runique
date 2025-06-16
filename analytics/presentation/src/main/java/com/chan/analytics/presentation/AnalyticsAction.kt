package com.chan.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}