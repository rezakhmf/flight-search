package com.reza.skyscannertest.di

import com.reza.skyscannertest.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication;


class BaseApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        //   DaggerMyAppComponent.builder().create(this).inject(this);


    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}