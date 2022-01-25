package com.bw.net

import com.bawei.mylib.BaseContant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
/**
 * @ClassName:
 * @Description:    ---
 * @Author:         szh
 * @CreateDate:     2022/1/25
 * @UpdateUser:     794
 * @UpdateRemark:   单例模式 网络框架
 * @Version:        1.0
 */
/**
 *
 * retrofit工厂，单例
 */

class MyNet private constructor(){

    companion object{
        /*
        * 延迟加载，第一次加载
        *
        * */
        val instance : MyNet by lazy { MyNet() }
    }

    private val intercreptor: Interceptor
    private val retrofit:Retrofit

    init {
        /**
         * 初始化通用拦截器
         * */
        intercreptor= Interceptor {
                chain-> val request = chain.request()
            .newBuilder()
            .addHeader("Content_Type","application/json")
            .addHeader("charset","UTF-8")
            .addHeader("token", BaseContant.KEY_SP_TOKEN)
            .build()

            chain.proceed(request)

        }

        /*
        * 初始化retrofit
        *
        * */
        retrofit =  Retrofit.Builder()
            .baseUrl(BaseContant.SERVER_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(initClient())
            .build()
    }

    /*
    * okhttp创建
    * */

    private fun initClient():OkHttpClient{

        return OkHttpClient.Builder()
            .addInterceptor(intercreptor)
            .addInterceptor(initLogIntereptor())
            .build()
    }
    /*
    *
    * 日志拦截器
    * */
    private fun initLogIntereptor():HttpLoggingInterceptor{
        val httpLoggingInterceptor=HttpLoggingInterceptor()
        httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor;
    }

    /**
     * 具体服务实例化
     */
    fun <T> create(servie:Class<T>):T{
        return retrofit.create(servie)
    }

}