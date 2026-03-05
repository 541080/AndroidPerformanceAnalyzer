package com.maximus.dxhub.performance_analyzer

import android.app.Application
import android.util.Log

object PerformanceAnalyzer {

    fun initialize(application: Application) {

        // start monitoring
        println("Performance Analyzer Initialized")
        Log.d("PerformanceAnalyzer","Performance Analyzer Initialized")
    }
}