package com.example.jetpackplayground.Workmanager.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.jetpackplayground.R
import com.example.jetpackplayground.Workmanager.WorkManager2

class WorkManagerWithCoroutineActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManager = OneTimeWorkRequestBuilder<WorkManager2>().build()
        WorkManager.getInstance(this).enqueue(workManager)

    }
}