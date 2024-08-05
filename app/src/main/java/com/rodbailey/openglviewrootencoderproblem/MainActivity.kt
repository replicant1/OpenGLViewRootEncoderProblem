package com.rodbailey.openglviewrootencoderproblem

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.rodbailey.openglviewrootencoderproblem.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("*** Into MainActivity.onCreate ***")

        ActivityCompat.requestPermissions(
            this,
            listOf(
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.RECORD_AUDIO
            ).toTypedArray(), 0
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



}