package com.example.jetpackplayground.Workmanager.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.jetpackplayground.R
import com.example.jetpackplayground.Workmanager.WorkManagerC
import com.example.jetpackplayground.Workmanager.WorkManagerD
import com.example.jetpackplayground.Workmanager.WorkManagerE


// WorkManager Chaining

// C -> 순서 상관 없이 실행 되도 괜찮음
// D -> 순서 상관 없이 실행 되도 괜찮음
// E -> 무조건 A / B 모두 실행 된 뒤에 실행 되어야 한다

class WorkManagerChainingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManagerC = OneTimeWorkRequestBuilder<WorkManagerC>().build()
        val workManagerD = OneTimeWorkRequestBuilder<WorkManagerD>().build()
        val workManagerE = OneTimeWorkRequestBuilder<WorkManagerE>().build()

//        기존 방식 -> C,D,E / C,D,E / ... 실행
//        WorkManager.getInstance(this).enqueue(workManagerC)
//        WorkManager.getInstance(this).enqueue(workManagerD)
//        WorkManager.getInstance(this).enqueue(workManagerE)

        // C & D를 모두 마무리하고 E를 실행해보자
        // C,D / C, D / ... / E
        WorkManager.getInstance(this)
            .beginWith(listOf(workManagerC, workManagerD))
            .then(workManagerE)
            .enqueue()

    }
}