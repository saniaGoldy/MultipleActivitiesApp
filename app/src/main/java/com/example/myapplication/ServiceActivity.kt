package com.example.myapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class ServiceActivity : AppCompatActivity() {

    private lateinit var service: CounterService
    private var bound = false
    private val connection = object: ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            val binder = p1 as CounterService.ServiceBinder
            service = binder.getService()
            bound = true
            Log.d("MyApp", "onServiceConnected")
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            bound=false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        var text = "fuck"
        findViewById<Button>(R.id.button).setOnClickListener{
            if (bound){
                text = service.getHowManyTimesWasAccessed().toString()
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }else{
                Log.d("MyApp", "Button clicked: not bound yet")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this, CounterService::class.java).also {
            bindService(it, connection, Context.BIND_AUTO_CREATE)
        }
        Log.d("MyApp", "onStart: Service bound")
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        bound=false
        Log.d("MyApp", "onStop")
    }

}