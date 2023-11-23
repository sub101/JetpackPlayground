package com.example.jetpackplayground.Workmanager

import android.content.Context
import android.util.Log
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class WorkManagerA(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result { // 클래스를 상속받고 백그라운드에서 실행하고자 하는 코드
        for(i in 1..10) {
            sleep(1000)
            Log.d("WorManagerA", i.toString())
        }

        return Result.success()
        // 작업 상태를 나타내는 Result에 정의된 success(), failure(), retry() 등의 메소드를 통해 결과를 반환
        // 반환된 값에 따라서 이후 동작을 결정할 수 있다. (재시도, 중단 등)
    }

}