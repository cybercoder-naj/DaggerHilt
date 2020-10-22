package com.nishant.daggerhilt.di

import com.google.gson.Gson
import com.nishant.daggerhilt.ui.activities.SomeInterface
import com.nishant.daggerhilt.ui.activities.SomeInterfaceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class MyModule {

    @Singleton
    @Provides
    fun provideSomeInterface(): SomeInterface {
        return SomeInterfaceImpl()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}