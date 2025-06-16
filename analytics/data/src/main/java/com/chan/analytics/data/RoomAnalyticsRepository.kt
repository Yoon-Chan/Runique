package com.chan.analytics.data

import com.chan.analytics.domain.AnalyticsRepository
import com.chan.analytics.domain.AnalyticsValue
import com.example.core.database.dao.AnalyticsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.milliseconds

class RoomAnalyticsRepository(
    private val analyticsDao: AnalyticsDao
) : AnalyticsRepository {

    override suspend fun getAnalyticsValue(): AnalyticsValue {
        return withContext(Dispatchers.IO) {
            val totalDistance = async { analyticsDao.getTotalDistance() }
            val totalTimeMillis = async { analyticsDao.getTotalTimeRun() }
            val maxRunSpeed = async { analyticsDao.getMaxRunSpeed() }
            val avgDistancePerRun = async { analyticsDao.getAvgDistancePerRun() }
            val avgPacePerRun = async { analyticsDao.getAvgPacePerRun() }

            AnalyticsValue(
                totalDistanceRun = totalDistance.await(),
                totalTimeRun = totalTimeMillis.await().milliseconds,
                fastestEverRun = maxRunSpeed.await(),
                avgDistanceRun = avgDistancePerRun.await(),
                avgPacePerRun = avgPacePerRun.await()
            )
        }
    }
}