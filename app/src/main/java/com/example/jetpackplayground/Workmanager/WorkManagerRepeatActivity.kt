package com.example.jetpackplayground.Workmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.jetpackplayground.R
import java.util.concurrent.TimeUnit

class WorkManagerRepeatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManager =
            PeriodicWorkRequestBuilder<RepeatWorkManager>(15, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(workManager)

    }
}