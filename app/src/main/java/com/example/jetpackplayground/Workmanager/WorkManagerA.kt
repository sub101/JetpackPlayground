package com.example.jetpackplayground.Workmanager

import android.content.Context
import android.util.Log
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class WorkManagerA(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {
        for(i in 1..10) {
            sleep(1000)
            Log.d("WorManagerA", i.toString())
        }

        return Result.success()
    }

}