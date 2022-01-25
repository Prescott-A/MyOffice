package com.bawei.imageload

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import java.io.File

/**
 * @ClassName:      ImagerLoaderManager$
 * @Description:    ---
 * @Author:         szh
 * @CreateDate:     2022/1/15$
 * @UpdateUser:     794
 * @UpdateRemark:   这里是与外界连接的 直接调用这个方法即可
 * @Version:        1.0
 */
class ImagerLoaderManager private constructor(): ImagerLoader {

    var imagerLoader: ImagerLoader? = null

    /**
     * 图片框架初始化配置 必须调用实现 推荐在Application的onCreate方法中进行初始化
     * @param type
     */
    fun init(type: ImageType) {
        when (type) {
            ImageType.GLIDE -> imagerLoader = GlideStrategy()
            ImageType.PICASSO -> {

            }
            else -> imagerLoader = GlideStrategy()
        }
    }

    override fun loadFileIntoImageView(
        cotext: Context,
        file: File,
        img: ImageView,
        config: ImageOptions
    ) {
        imagerLoader!!.loadFileIntoImageView(cotext, file, img, config)
    }

    override fun loadByteIntoImageView(
        cotext: Context,
        bytes: ByteArray,
        img: ImageView,
        config: ImageOptions
    ) {
        imagerLoader!!.loadByteIntoImageView(cotext, bytes, img, config)
    }

    override fun loadUriIntoImageView(
        cotext: Context,
        uri: Uri,
        img: ImageView,
        config: ImageOptions
    ) {
        imagerLoader!!.loadUriIntoImageView(cotext, uri, img, config)
    }

    override fun loadResourceIntoImageView(
        cotext: Context,
        resource: Int,
        img: ImageView,
        config: ImageOptions
    ) {
        imagerLoader!!.loadResourceIntoImageView(cotext, resource, img, config)
    }

    override fun loadStringIntoImageView(
        cotext: Context,
        url: String,
        img: ImageView,
        config: ImageOptions
    ) {
        imagerLoader!!.loadStringIntoImageView(cotext, url, img, config)
    }


    companion object{
        @Volatile
        private var imagerLoaderManager : ImagerLoaderManager? = null
        @JvmStatic
        val instence : ImagerLoaderManager?
        get() {
            if (imagerLoaderManager == null){
                synchronized(ImagerLoaderManager::class.java){
                    if (imagerLoaderManager == null){
                        imagerLoaderManager = ImagerLoaderManager()
                    }
                }
            }
            return imagerLoaderManager
        }
    }
}