package com.example.pavel.fakedataloader.di;

import android.content.Context;

import com.example.pavel.fakedataloader.di.modules.ContextModule;
import com.example.pavel.fakedataloader.di.modules.PostsModule;
import com.example.pavel.fakedataloader.mvp.presenters.PostsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, PostsModule.class})
public interface AppComponent {
	Context getContext();

	void inject(PostsPresenter postsPresenter);
}
