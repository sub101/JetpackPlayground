package com.example.jetpackplayground.Workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.Date

class RepeatWorkManager(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        Log.d("WorkManager1", "doWork")

        val format = SimpleDateFormat("hh:mm:ss")
        val currentTime = format.format(Date())

        Log.d("WorkManager1", currentTime)

        return Result.success()
    }
}