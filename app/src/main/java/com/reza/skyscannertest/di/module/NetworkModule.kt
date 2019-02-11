package com.reza.skyscannertest.di.module

import android.content.Context
import com.reza.skyscannertest.data.flightPrices.FlightPricesApi
import com.reza.skyscannertest.ui.main.BASE_URL
import com.reza.skyscannertest.ui.main.TIMEOUT_IN_MS
import com.reza.skyscannertest.utils.ApiInterceptor
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideFlighPricesApi(retrofit: Retrofit): FlightPricesApi {
        return retrofit.create(FlightPricesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideApiInterceptor(): ApiInterceptor {
        return ApiInterceptor()
    }

    @Provides
    @Singleton
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: okhttp3.Cache, apiInterceptor: ApiInterceptor): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(apiInterceptor)
            .connectTimeout(TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
            .cache(cache).build()
    }

    @Provides
    @Singleton
    fun provideCache(context: Context): Cache {

        val cacheSize: Long = 5 * 1024 * 1024
        var cacheDir: File = context.cacheDir
        return Cache(cacheDir, cacheSize)
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}