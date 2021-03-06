package com.kotlin.tutorial.retrofit.app1.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.tutorial.retrofit.app1.R

import com.kotlin.tutorial.retrofit.app1.http.RetrofitManager
import com.safframework.lifecycle.RxLifecycle
import com.safframework.utils.RxJavaUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
    }

    private fun initData() {

        RetrofitManager.get()
                .apiService()
                .publicEvent("fengzhizi715")
                .compose(RxLifecycle.bind(this).toLifecycleTransformer())
                .compose(RxJavaUtils.maybeToMain())
                .subscribe()
    }
}
