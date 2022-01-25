package com.bawei.mvp.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.mvp.presenter.IPresenter;

/**
 * @ClassName: BaseActivity$
 * @Description: ---
 * @Author: szh
 * @CreateDate: 2022/1/20$
 * @UpdateUser: 794
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView {
    public P mPresenter;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bandLayout());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();


    protected abstract int bandLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!= null){
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }
}
