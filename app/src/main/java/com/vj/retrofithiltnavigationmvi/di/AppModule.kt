package com.vj.retrofithiltnavigationmvi.di

import com.squareup.moshi.Moshi
import com.vj.retrofithiltnavigationmvi.helper.ArrayListMoshiAdapter
import com.vj.retrofithiltnavigationmvi.network.GithubEndpoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesHttpLogger() = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun providesClient()= OkHttpClient.Builder().apply {
        this.addInterceptor(providesHttpLogger())
    }.build()

    @Provides
    @Singleton
    fun providesNetworkInstance(): GithubEndpoint {
        return Retrofit.Builder().run {
            baseUrl(BuildConfig.BASE_URL)
            client(providesClient())
            addConverterFactory(
                MoshiConverterFactory.create(
                Moshi
                    .Builder()
                    .add(ArrayListMoshiAdapter())
                    .build()
            ))
            build()
        }.create(GithubEndpoint::class.java)
    }
}