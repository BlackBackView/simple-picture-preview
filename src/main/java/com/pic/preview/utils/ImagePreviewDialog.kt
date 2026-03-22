package com.pic.preview.utils

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.pic.preview.R
import com.pic.preview.utils.ImagePagerAdapter

/**
 * @Description:
 * @Author: yang liv
 * @Date: 2025/4/10 14:53
 */
class ImagePreviewDialog(
    context: Context,
    private val imageUrl: String, // 当前图片的url
    private val imageUrls: List<String>,
) : Dialog(context, R.style.WeChatPhotoDialogStyle) {

    private lateinit var imagePagerAdapter: ImagePagerAdapter
    private lateinit var viewpager: ViewPager2
    private lateinit var indexView: TextView
    private lateinit var ivClose: ImageView
    private lateinit var pageChangeCallback: ViewPager2.OnPageChangeCallback


    private fun updateIndexView(position: Int) {
        indexView.text = "${position + 1} / ${imageUrls.size}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_image_preview)

        viewpager = findViewById(R.id.viewPager)
        ivClose = findViewById(R.id.ivClose)
        indexView = findViewById(R.id.tvIndexView)

        imagePagerAdapter = ImagePagerAdapter(imageUrls)
        viewpager.adapter = imagePagerAdapter
        viewpager.setCurrentItem(imageUrls.indexOf(imageUrl), false) // 初始化禁止滑动
        updateIndexView(viewpager.currentItem)

        pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // 页面滑动时调用
            }

            override fun onPageSelected(position: Int) {
                // 页面选择完成时调用
                updateIndexView(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                // 页面滚动状态改变时调用
            }
        }
        viewpager.registerOnPageChangeCallback(pageChangeCallback)


        ivClose.setOnClickListener {
            dismiss()
        }

        setOnDismissListener {
            viewpager.unregisterOnPageChangeCallback(pageChangeCallback)
        }


    }



}