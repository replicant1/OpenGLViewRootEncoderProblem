package com.rodbailey.openglviewrootencoderproblem

import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.pedro.common.ConnectChecker
import com.pedro.encoder.input.video.CameraHelper
import com.pedro.library.rtmp.RtmpCamera1
import com.pedro.library.view.OpenGlView
import com.rodbailey.openglviewrootencoderproblem.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), ConnectChecker, SurfaceHolder.Callback {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var rtmpCamera1: RtmpCamera1
    private lateinit var openGLView: OpenGlView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        ActivityCompat.requestPermissions(
            this,
            listOf(
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.RECORD_AUDIO
            ).toTypedArray(), 0
        )



        setContentView(binding.root)
//        rtmpCamera1.startPreview(CameraHelper.Facing.BACK, 1280, 720)

        openGLView = binding.surfaceView
        rtmpCamera1 = RtmpCamera1(openGLView, this)
        openGLView.holder.addCallback(this)
    }

    override fun onAuthError() {

    }

    override fun onAuthSuccess() {

    }

    override fun onConnectionFailed(reason: String) {

    }

    override fun onConnectionStarted(url: String) {

    }

    override fun onConnectionSuccess() {

    }

    override fun onDisconnect() {

    }

    override fun onNewBitrate(bitrate: Long) {

    }

    override fun surfaceCreated(holder: SurfaceHolder) {

    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        rtmpCamera1.startPreview()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        rtmpCamera1.stopPreview()
    }


}