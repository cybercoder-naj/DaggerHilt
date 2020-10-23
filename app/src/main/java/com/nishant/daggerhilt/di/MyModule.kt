package com.nishant.daggerhilt.di

import com.google.gson.Gson
import com.nishant.daggerhilt.ui.activities.SomeInterface
import com.nishant.daggerhilt.ui.activities.SomeInterfaceImpl1
import com.nishant.daggerhilt.ui.activities.SomeInterfaceImpl2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class MyModule {

    @Impl1
    @Singleton
    @Provides
    fun provideSomeInterface1(): SomeInterface {
        return SomeInterfaceImpl1()
    }

    @Impl2
    @Singleton
    @Provides
    fun provideSomeInterface2(): SomeInterface {
        return SomeInterfaceImpl2()
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2