package com.bawei.imageload

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import java.io.File

/**
 * @ClassName:      ImagerLoader$
 * @Description:    ---
 * @Author:         szh
 * @CreateDate:     2022/1/15$
 * @UpdateUser:     794
 * @UpdateRemark:   图片有多种方式进行加载
 * @Version:        1.0
 */
interface ImagerLoader {
    /**
     * 参数一：上下文
     * 参数二：通过什么去进行加载
     * 参数三：目标作用到ImageView上
     * 参数四：图片的选项配置
     */

    /**
     * 通过文件加载
     */
    fun loadFileIntoImageView(cotext :Context, file : File, img : ImageView, config : ImageOptions)

    /**
     * 通过byte数组加载
     */

    fun loadByteIntoImageView(cotext :Context, bytes: ByteArray , img : ImageView, config : ImageOptions)

    /**
     * 通过Uri加载
     */

    fun loadUriIntoImageView(cotext :Context, uri : Uri, img : ImageView, config : ImageOptions)

    /**
     *通过资源进行加载
     */
    fun loadResourceIntoImageView(cotext :Context, resource : Int, img : ImageView, config : ImageOptions)


    /**
     * 通过String url进行加载
     */

    fun loadStringIntoImageView(cotext :Context, url : String, img : ImageView, config : ImageOptions)


}