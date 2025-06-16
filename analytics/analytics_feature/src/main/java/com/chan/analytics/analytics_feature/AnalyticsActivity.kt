package com.chan.analytics.analytics_feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chan.analytics.data.di.analyticsModule
import com.chan.analytics.presentation.AnalyticsDashboardStateScreenRoot
import com.chan.analytics.presentation.di.analyticsPresentationModule
import com.example.core.presentation.designsystem.RuniqueTheme
import com.google.android.play.core.splitcompat.SplitCompat
import org.koin.core.context.loadKoinModules

class AnalyticsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(listOf(analyticsModule, analyticsPresentationModule))
        SplitCompat.installActivity(this)

        setContent {
            RuniqueTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "analytics_dashboard",
                ) {
                    composable("analytics_dashboard") {
                        AnalyticsDashboardStateScreenRoot(
                            onBackClick = { finish() }
                        )
                    }
                }
            }
        }
    }
}