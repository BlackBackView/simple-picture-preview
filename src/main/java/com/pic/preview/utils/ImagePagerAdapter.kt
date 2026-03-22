package com.pic.preview.utils

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pic.preview.R
import com.github.piasy.biv.view.BigImageView

/**
 * @Description:
 * @Author: yang liv
 * @Date: 2025/4/10 15:43
 */
class ImagePagerAdapter(private val imageUrls: List<String>) :
    RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: BigImageView = itemView.findViewById(R.id.bigImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_picture_preview, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUrl = imageUrls[position]
        // 使用你的方式加载图片到 BigImageView
        holder.imageView.showImage(Uri.parse(imageUrl))
    }

    override fun getItemCount(): Int = imageUrls.size
}