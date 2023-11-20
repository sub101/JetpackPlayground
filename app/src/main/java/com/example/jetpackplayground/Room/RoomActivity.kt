package com.example.jetpackplayground.Room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpackplayground.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = TextDatabase.getDatabase(this)

        CoroutineScope(Dispatchers.IO).launch {
            db.textDao().insert(TextEntity(0, "HELLO"))
            Log.d("MAINACTIVITY", db.textDao().getAllData().toString())
        }
    }
}
