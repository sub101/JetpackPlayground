package com.example.jetpackplayground.Workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class WorkManagerB(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {

        // activity에서 넘긴 값을 받음
        val a = inputData.getInt("a", 1000) // key- value 형태, 값을 안넘겨줄 수 있으니 디폴트값 설정
        val b = inputData.getInt("b", 2000)
        val c = inputData.getInt("c", 3000)

        Log.d("WorkManagerB", a.toString())
        Log.d("WorkManagerB", b.toString())
        Log.d("WorkManagerB", c.toString())

        // 데이터를 넘기고 싶을 때 , 완료되면서 activity에 알려주기
        val output: Data = workDataOf("result" to 10)

        return Result.success(output)
    }
}