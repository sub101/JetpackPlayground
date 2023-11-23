package com.example.jetpackplayground.Workmanager.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.jetpackplayground.R
import com.example.jetpackplayground.Workmanager.TestWorkManager

class WorkManagerExistingWorkPolicyAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testBtn = findViewById<Button>(R.id.testBtn)
        testBtn.setOnClickListener {

            val testWorkManager = OneTimeWorkRequestBuilder<TestWorkManager>().build()
            // 기존에 했던 방식
            //WorkManager.getInstance(this).enqueue(testWorkManager)

            // 새로운방식
            // WorkManager.getInstance(this).enqueueUniqueWork("test", ExistingWorkPolicy.KEEP, testWorkManager)
            WorkManager.getInstance(this).enqueueUniqueWork("test", ExistingWorkPolicy.REPLACE, testWorkManager)
        }

    }
}