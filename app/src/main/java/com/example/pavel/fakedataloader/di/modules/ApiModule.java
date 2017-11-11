package com.example.pavel.fakedataloader.di.modules;

import com.example.pavel.fakedataloader.app.PostsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {RetrofitModule.class})
public class ApiModule {
	@Provides
	@Singleton
	public PostsApi provideApi(Retrofit retrofit) {
		return retrofit.create(PostsApi.class);
	}
}
