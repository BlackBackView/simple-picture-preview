package com.pic.preview.module

import android.app.Application
import android.content.Context
import com.github.piasy.biv.BigImageViewer
import com.github.piasy.biv.loader.fresco.FrescoImageLoader
import com.pic.preview.utils.ImagePreviewDialog

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

    /**
     * 打开图片预览
     * @param currentUrl 当前选中的图片地址
     * @param imageUrls   所有需要预览的图片地址列表
     */
    fun preview(context: Context, currentUrl: String, imageUrls: List<String>) {
        ImagePreviewDialog(context, currentUrl, imageUrls).show()
    }
}