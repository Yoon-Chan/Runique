package com.chan.analytics.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chan.analytics.presentation.component.AnalyticsCard
import com.example.core.presentation.designsystem.RuniqueTheme
import com.example.core.presentation.designsystem.component.RuniqueScaffold
import com.example.core.presentation.designsystem.component.RuniqueToolbar
import org.koin.androidx.compose.koinViewModel

@Composable
fun AnalyticsDashboardStateScreenRoot(
    onBackClick: () -> Unit,
    viewModel: AnalyticsDashboardViewModel = koinViewModel()
) {
    AnalyticsDashboardStateScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                AnalyticsAction.OnBackClick -> onBackClick()
            }

        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AnalyticsDashboardStateScreen(
    state: AnalyticsDashboardState?,
    onAction: (AnalyticsAction) -> Unit
) {
    RuniqueScaffold(
        topAppBar = {
            RuniqueToolbar(
                showBackButton = true,
                title = stringResource(R.string.analytics),
                onBackClick = {
                    onAction(AnalyticsAction.OnBackClick)
                }
            )
        }
    ) { padding ->
        if (state == null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    AnalyticsCard(
                        modifier = Modifier.weight(1f),
                        title = stringResource(R.string.total_distance_run),
                        value = state.totalDistanceRun
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    AnalyticsCard(
                        modifier = Modifier.weight(1f),
                        title = stringResource(R.string.total_time_run),
                        value = state.totalTimeRun
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    AnalyticsCard(
                        modifier = Modifier.weight(1f),
                        title = stringResource(R.string.fastest_ever_run),
                        value = state.fastestEverRun
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    AnalyticsCard(
                        modifier = Modifier.weight(1f),
                        title = stringResource(R.string.avg_distance_per_run),
                        value = state.avgDistance
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    AnalyticsCard(
                        modifier = Modifier.weight(1f),
                        title = stringResource(R.string.avg_pace_per_run),
                        value = state.avgPace
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun AnalyticsDashboardStateScreenPreview() {
    RuniqueTheme {
        AnalyticsDashboardStateScreen(
            state = AnalyticsDashboardState(
                totalDistanceRun = "0.2 km",
                totalTimeRun = "0d 0h 0m",
                fastestEverRun = "143.9 km/h",
                avgPace = "07:10",
                avgDistance = "0.1 km"
            ),
            onAction = {}
        )
    }
}