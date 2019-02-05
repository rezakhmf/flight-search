package com.reza.skyscannertest.di.component

import com.reza.skyscannertest.BaseApp
import com.reza.skyscannertest.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
    AppModule::class]
)
interface AppComponent: AndroidInjector<BaseApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApp>()
}