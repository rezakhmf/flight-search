package com.reza.skyscannertest.di.component

import com.reza.skyscannertest.BaseApp
import com.reza.skyscannertest.di.module.ActivityBuilder
import com.reza.skyscannertest.di.module.AppModule
import com.reza.skyscannertest.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ActivityBuilder::class]
)
interface AppComponent: AndroidInjector<BaseApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApp>() {}
}