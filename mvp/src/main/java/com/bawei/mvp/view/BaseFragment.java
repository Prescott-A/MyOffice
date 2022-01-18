package com.bawei.mvp.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.mvp.presenter.IPresenter;

/**
 * @ClassName: BaseActivity$
 * @Description: ---
 * @Author: szh
 * @CreateDate: 2022/1/18$
 * @UpdateUser: 794
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public abstract class BaseActivity <P extends IPresenter> extends AppCompatActivity {

    public P mPresenter;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bandLayout());
        initView();
        initData();
    }

    /**
     * 设置布局
     * @return
     */
    protected abstract int bandLayout();

    /**
     * 控件初始化
     */
    protected abstract void initView();

    /**
     * 加载数据
     */
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!= null){
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }
}
