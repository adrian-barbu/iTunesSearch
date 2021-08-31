package com.calvin.itunesearch.di.component;

import android.app.Application;

import com.calvin.itunesearch.iTunesSearchApp;
import com.calvin.itunesearch.di.builder.ActivityBuilder;
import com.calvin.itunesearch.di.module.ApiServiceModule;
import com.calvin.itunesearch.di.module.ApplicationModule;
import com.calvin.itunesearch.di.module.OkHttpClientModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {ApplicationModule.class ,  AndroidInjectionModule.class , ActivityBuilder.class})
public interface ApplicationComponent {

    void inject(iTunesSearchApp daggerExampleApp);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        Builder AppModule(ApplicationModule module);

        Builder ApiService(ApiServiceModule module);

        Builder httpModule(OkHttpClientModule module);

        ApplicationComponent build();
    }
}
