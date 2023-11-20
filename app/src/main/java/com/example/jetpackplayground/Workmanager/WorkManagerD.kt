package com.example.jetpackplayground.Workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkManagerD(context : Context, workerParameters: WorkerParameters)  : Worker(context, workerParameters){

    override fun doWork(): Result {

        for(i in 0..3) {
            Thread.sleep(1000)
            Log.d("WorkManagerD", i.toString())
        }

        return Result.success()

    }
}