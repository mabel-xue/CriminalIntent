package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mabelxue on 2017/2/15.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        //解释：使用容器视图资源ID向FragmentManager请求并获取fragment。
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        //解释：如果指定容器视图资源ID的fragment不存在，则新建CrimeFragment，并启动新的fragment事务，将新建fragment添加到队列中。
        if(fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    protected abstract Fragment createFragment();
}
