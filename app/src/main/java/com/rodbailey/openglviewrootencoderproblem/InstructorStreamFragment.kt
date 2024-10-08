package com.rodbailey.openglviewrootencoderproblem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pedro.common.ConnectChecker
import com.pedro.encoder.input.video.CameraHelper
import com.pedro.library.rtmp.RtmpCamera1
import com.rodbailey.openglviewrootencoderproblem.databinding.FragmentInstructorStreamBinding

/**
 * Why does OPTION 2 work but OPTION 1 does not? (see [onCreateView]).
 */
class InstructorStreamFragment :
    Fragment(),
    ConnectChecker by NullConnectChecker(),
    SurfaceHolder.Callback  {

    private lateinit var binding: FragmentInstructorStreamBinding
    private val myCameraHolder =  MyCameraHolder()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        super.onCreate(savedInstanceState)
        binding = FragmentInstructorStreamBinding.inflate(inflater, container, false)

        // OPTION 1: This doesn't work - which makes no sense to me.
        // See [MyCameraHolder#save] for explanation of how to fix OPTION 1.
//        myCameraHolder.save(binding.surfaceView, this)

        // OPTION 2: This does work.
        myCameraHolder.save(RtmpCamera1(binding.surfaceView, this))

        binding.surfaceView.holder.addCallback(this)
        return binding.root
    }

    override fun surfaceCreated(holder: SurfaceHolder) {

    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        if (myCameraHolder.camera()!!.isOnPreview) {
            myCameraHolder.camera()!!.stopPreview()
        }

        // Hard code a resolution that your phone's camera supports. If the width and height
        // are the same, the preview is distorted. Otherwise, the preview is fine.
        // On a Google Pixel 6:
        // a) width = 1080, height = 1080 shows a distorted preview.
        // b) width = 640, height = 480 works fine
        myCameraHolder.camera()!!.startPreview(CameraHelper.Facing.BACK, 1080, 1080)
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        myCameraHolder.camera()!!.stopPreview()
    }
}

