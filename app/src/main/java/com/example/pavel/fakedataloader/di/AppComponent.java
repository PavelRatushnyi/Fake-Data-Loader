package com.example.pavel.fakedataloader.di;

import com.example.pavel.fakedataloader.di.modules.ContextModule;
import com.example.pavel.fakedataloader.di.modules.PhrasesModule;
import com.example.pavel.fakedataloader.mvp.presenters.PostsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, PhrasesModule.class})
public interface AppComponent {
	void inject(PostsPresenter postsPresenter);
}