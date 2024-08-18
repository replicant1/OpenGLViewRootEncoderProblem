package com.rodbailey.openglviewrootencoderproblem

import android.view.SurfaceView
import com.pedro.common.ConnectChecker
import com.pedro.library.rtmp.RtmpCamera1

/**
 * Holds a reference to an [RtmpCamera1]. May also create that [RtmpCamera1].
 */
class MyCameraHolder() {
    private var rtmpCamera1: RtmpCamera1? = null

    fun save(value: RtmpCamera1) {
        rtmpCamera1 = value
    }

    /**
     * As Pedro advises, changing the type of the [surfaceView] parameter to "OpenGlView"
     * makes the OPTION 1 work. There are two RtmpCamera1 constructors - one that takes a
     * [SurfaceView] and another that takes an OpenGlView.
     */
    fun save(surfaceView: SurfaceView, connectChecker: ConnectChecker) {
        rtmpCamera1 = RtmpCamera1(surfaceView, connectChecker)
    }

    fun camera(): RtmpCamera1? {
        return rtmpCamera1
    }
}