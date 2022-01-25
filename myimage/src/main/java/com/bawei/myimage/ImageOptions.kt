package com.bawei.imageload

/**
 * @ClassName:      ImageOptions$
 * @Description:    ---
 * @Author:         szh
 * @CreateDate:     2022/1/15$
 * @UpdateUser:     794
 * @UpdateRemark:   图片的一些配置选项 这里是通过建造者进行处理的
 *
 * 图片的话有：占位图，错误图，静态图，gif动图
 * 还有去进行的三级缓存：图片的大小 内存缓存 磁盘缓存
 *
 * 先去抽取 做成内部类的建造者模式  然后初始化  赋值   已经构造方法
 * @Version:        1.0
 */
class ImageOptions(
    /**
     * 占位图
     */
    val placeImage: Int,
    /**
     * 错误图
     */
    val errorImage: Int,
    /**
     * 静态图片
     */
    val isStaticImg: Boolean,
    /**
     * Gif动图
     */
    val isGif: Boolean,

    imageSize: Int,

    skipMemoryCache: Boolean,

    skipDisCache: Boolean
) {

    /**
     * 图片大小
     */
    val imageSize: Int

    /**
     * 关闭内存缓存
     */
    val isSkipMemoryCache: Boolean

    /**
     * 关闭磁盘缓存
     */
    val isSkipDisCache: Boolean

    class Builder {
        /**
         * 占位图
         */
        private var placeImage = 0

        /**
         * 错误图
         */
        private var errorImage = 0

        /**
         * 静态图片
         */
        private var isStaticImg = false

        /**
         * Gif动图
         */
        private var isGif = false

        /**
         * 图片大小
         */
        private var imageSize: Int = 0

        /**
         * 关闭内存缓存
         */
        private var skipMemoryCache = false

        /**
         * 关闭磁盘缓存
         */
        private var skipDisCache = false

        fun setPlaceImage(placeImage: Int): Builder {
            this.placeImage = placeImage
            return this
        }

        fun setErrorImage(errorImage: Int): Builder {
            this.errorImage = errorImage
            return this
        }

        fun setStaticImg(staticImg: Boolean): Builder {
            isStaticImg = staticImg
            return this
        }

        fun setGif(gif: Boolean): Builder {
            isGif = gif
            return this
        }

        fun setImageSize(imageSize: Int): Builder {
            this.imageSize = imageSize
            return this
        }

        fun setSkipMemoryCache(skipMemoryCache: Boolean): Builder {
            this.skipMemoryCache = skipMemoryCache
            return this
        }

        fun setSkipDisCache(skipDisCache: Boolean): Builder {
            this.skipDisCache = skipDisCache
            return this
        }

        fun build(): ImageOptions {
            return ImageOptions(
                placeImage,
                errorImage,
                isGif,
                isGif,
                imageSize,
                skipMemoryCache,
                skipDisCache
            )
        }
    }

    init {
        check(!(isStaticImg && isGif))
        { "[isStaticImg][isGif] not at the same time set up is True" }
        this.imageSize = imageSize
        isSkipMemoryCache = skipMemoryCache
        isSkipDisCache = skipDisCache
    }

}