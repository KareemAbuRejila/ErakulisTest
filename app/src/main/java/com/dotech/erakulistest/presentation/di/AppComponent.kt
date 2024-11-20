package com.dotech.erakulistest.presentation.di

import com.dotech.erakulistest.presentation.MyApp
import dagger.Component
import javax.inject.Singleton

//@Singleton
//@Component(modules = [AppModule::class])
interface AppComponent {

//    @Component.Builder
    interface Builder {
        fun appModule(module: AppModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: MyApp)
}
