package com.reza.skyscannertest.ui.base

import android.os.Bundle
import com.reza.skyscannertest.di.module.NetworkModule
import com.reza.skyscannertest.utils.NetManager
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity: DaggerAppCompatActivity(), BaseFragment.Callback {


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    fun isNetworkConnected(): Boolean {
        return NetManager(applicationContext).isConnectedToInternet
    }

}