package com.rodbailey.openglviewrootencoderproblem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import com.pedro.common.ConnectChecker
import com.pedro.encoder.input.video.CameraHelper
import com.pedro.library.rtmp.RtmpCamera1
import com.pedro.library.view.OpenGlView
import com.rodbailey.openglviewrootencoderproblem.databinding.FragmentInstructorStreamBinding

class InstructorStreamFragment : Fragment(), ConnectChecker, SurfaceHolder.Callback {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: FragmentInstructorStreamBinding
    private lateinit var rtmpCamera1: RtmpCamera1
    private lateinit var openGLView: OpenGlView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        super.onCreate(savedInstanceState)

        binding = FragmentInstructorStreamBinding.inflate(inflater, container, false)

        openGLView = binding.surfaceView
        rtmpCamera1 = RtmpCamera1(openGLView, this)
        openGLView.holder.addCallback(this)

        return binding.root
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
        rtmpCamera1.startPreview(CameraHelper.Facing.BACK, 1280, 720)
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        rtmpCamera1.stopPreview()
    }

}