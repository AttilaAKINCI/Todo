package com.akinci.todo.common.di

import com.akinci.todo.common.coroutine.CoroutineContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // live as long as hole application
object AppModule {

    /** Coroutine context provider
     * START
     * **/
    @Provides
    @Singleton
    fun provideCoroutineContext() = CoroutineContextProvider()
    /** END **/

}