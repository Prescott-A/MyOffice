package com.bawei.imageload

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.io.File
import java.lang.ref.SoftReference

/**
 * @ClassName:      GlideStrategy$
 * @Description:    ---
 * @Author:         szh
 * @CreateDate:     2022/1/15$
 * @UpdateUser:     794
 * @UpdateRemark:   这里进行了一个实例化方法 操作图片
 * @Version:        1.0
 */
class GlideStrategy : ImagerLoader {
    override fun loadFileIntoImageView(
        cotext: Context,
        file: File,
        img: ImageView,
        config: ImageOptions
    ) {
        loadImageView(cotext, file, img, config)
    }


    override fun loadByteIntoImageView(
        cotext: Context,
        bytes: ByteArray,
        img: ImageView,
        config: ImageOptions
    ) {
        loadImageView(cotext, bytes, img, config);
    }

    override fun loadUriIntoImageView(
        cotext: Context,
        uri: Uri,
        img: ImageView,
        config: ImageOptions
    ) {
        loadImageView(cotext, uri, img, config);
    }

    override fun loadResourceIntoImageView(
        cotext: Context,
        resource: Int,
        img: ImageView,
        config: ImageOptions
    ) {
        loadImageView(cotext, resource, img, config);
    }

    override fun loadStringIntoImageView(
        cotext: Context,
        url: String,
        img: ImageView,
        config: ImageOptions
    ) {
        loadImageView(cotext, url, img, config);
    }


    /**
     * 加载图片资源到ImageView控件上
     */
    private fun loadImageView(
        context: Context,
        obj: Any,
        img: ImageView,
        config: ImageOptions
    ) {

        val ctx = SoftReference(context)
        val load = Glide.with(ctx.get()!!).load(obj)
        setBuilderOptions(load, config);
        load.into(img)
    }

    /**
     * 设置图片的参数
     */
    private fun setBuilderOptions(load: RequestBuilder<Drawable>, config: ImageOptions) {
        if (null == config) {
            return
        }

        val options = RequestOptions()
        /**
         * 设置占位图
         */
        if (config.placeImage != 0) {
            options.placeholder(config.placeImage)
        }

        /**
         * 设置错误图
         */
        if (config.errorImage != 0) {
            options.error(config.errorImage)
        }

        /**
         * 关闭内存缓存
         */
        if (config.isSkipMemoryCache){
            options.skipMemoryCache(true)
        }
        /**
         * 关闭磁盘缓存
         */
        if (config.isSkipDisCache){
            options.diskCacheStrategy(DiskCacheStrategy.NONE)
        }

        /**
         * 释放资源
         */
        load.apply(options)

    }


}