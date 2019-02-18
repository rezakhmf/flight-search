package com.reza.skyscannertest.di.module

import android.content.Context
import com.reza.skyscannertest.di.BaseApp
import com.reza.skyscannertest.di.builder.flightPrices.ActivityBuilder
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(includes = arrayOf(AndroidSupportInjectionModule::class, ActivityBuilder::class))
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: BaseApp): Context {
        return app.applicationContext
    }
}