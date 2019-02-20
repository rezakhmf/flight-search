package com.reza.skyscannertest.di.component

import com.reza.skyscannertest.di.BaseApp
import com.reza.skyscannertest.di.module.AppModule
import com.reza.skyscannertest.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class]
)
interface AppComponent: AndroidInjector<BaseApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApp>() {}
}