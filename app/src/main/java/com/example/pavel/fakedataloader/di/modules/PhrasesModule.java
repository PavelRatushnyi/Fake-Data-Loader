package com.example.pavel.fakedataloader.di.modules;

import com.example.pavel.fakedataloader.app.PostsApi;
import com.example.pavel.fakedataloader.mvp.PostsService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiModule.class})
public class PhrasesModule {
	@Provides
	@Singleton
	public PostsService providePhrasesService(PostsApi postsApi) {
		return new PostsService(postsApi);
	}
}
