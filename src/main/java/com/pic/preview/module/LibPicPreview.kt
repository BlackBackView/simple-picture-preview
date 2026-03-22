package com.pic.preview.module

import android.app.Application
import com.github.piasy.biv.BigImageViewer
import com.github.piasy.biv.loader.fresco.FrescoImageLoader

/**
 * @Description:
 * @Author: yang liv
 * @Date: 2026/3/19 18:19
 */
object LibPicPreview {

    fun init(app: Application) {
        // 使用 Fresco 加载
        BigImageViewer.initialize(FrescoImageLoader.with(app))
        // 或者使用 Glide 加载
        // BigImageViewer.initialize(GlideImageLoader.with(app))
    }

}