package com.reza.skyscannertest.di.module

import android.app.Application
import android.content.Context
import com.reza.skyscannertest.BaseApp
import com.reza.skyscannertest.di.scope.PreApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @PreApplication
    fun provideContext(app: BaseApp): Context {
        return app.applicationContext
    }
}