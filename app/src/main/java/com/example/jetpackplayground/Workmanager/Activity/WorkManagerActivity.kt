package com.example.jetpackplayground.Workmanager.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.jetpackplayground.R
import com.example.jetpackplayground.Workmanager.WorkManagerA
import com.example.jetpackplayground.Workmanager.WorkManagerB

class WorkManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//         SimpleThread().start()
//
//        val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
//        WorkManager.getInstance(this).enqueue(workManagerA)

        // 보내줄 데이터 만들기
        val myData: Data = workDataOf(
            "a" to 10, //key-value 형태
            "b" to 20,
        )

        val workManagerB = OneTimeWorkRequestBuilder<WorkManagerB>().setInputData(myData)
            .build() //myData를 넣어 값을 넘김 -> WorkManagerB에서 inputData.getInstance() 활용해 값을 받ㅐ
        WorkManager.getInstance(this).enqueue(workManagerB)

        // WorkManagerB에서 리턴한 값을 어떻게 사용할지
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workManagerB.id)
            .observe(this, Observer { info ->

                if (info != null && info.state.isFinished) {
                    // 널이 아니거나, state가 finish면
                    val result = info.outputData.getInt("result", 10000) // result값을 받고 디폴트값은 10000
                    val result2 = info.outputData.getInt(
                        "result2",
                        20000
                    ) //WorkManagerB에서 반환하지 않는 값 -> 로그 찍어보면 디폴트값 20000 찍힘

                    Log.d("WorkManagerActivity", result.toString())
                    Log.d("WorkManagerActivity", result2.toString())
                }

            })
    }
}

//class SimpleThread : Thread() {
//    override fun run() {
//        super.run()
//
//        for (i in 1..10) {
//            Log.d("MainActivity", "$i")
//            sleep(1000) // 1초 쉼
//        }
//
//    }
//}
