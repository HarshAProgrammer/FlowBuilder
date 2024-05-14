package com.example.flowbuilder

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val data: Flow<Int> = producer()
            data.collect{
                Log.d("Harsh - 1",it.toString())
            }
        }
        GlobalScope.launch {
            val data: Flow<Int> = producer()
            delay(2500)
            data.collect{
                Log.d("Harsh - 2",it.toString())
            }
        }
//        GlobalScope.launch {
//            delay(3500)
//            job.cancel()
//        }
    }

    fun producer() = flow<Int> {
        val list  = listOf(1,2,3,4,5)
        list.forEach {
            delay(1000)
            emit(it)
        }
    }
}